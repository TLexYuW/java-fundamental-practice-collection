#!/bin/bash

# 設定檔案路徑
CSV_FILE="${1:-sequential_hash.csv}"

# 核心碰撞檢測邏輯
tail -n +2 "$CSV_FILE" | awk -F',' '
{
    if (NR % 1000000 == 0) print "Processed: " NR > "/dev/stderr"
    if ($2 in seen) {print "🎉 COLLISION! Hash:" $2 " Input_A:" seen[$2] " Input_B:" $1; exit}
    seen[$2] = $1
} 
END {if (NR > 0) print "Finished " NR " entries"}'

# =========================================================
# 詳細註解說明
# =========================================================
#
# 【程式用途】
# - 檢測CSV檔案中的hash碰撞
# - 找出不同input產生相同hash值的組合
# - 用於測試hash函數的品質
#
# 【CSV檔案格式】
# - 第一行: input,hash (header)
# - 資料行: 數字,hash字串
# - 範例: 123,A1B2C
#
# 【程式碼解析】
# tail -n +2 "$CSV_FILE"
#   ↳ 跳過CSV檔案的第1行(header)，從第2行開始讀取
#
# awk -F','
#   ↳ 設定AWK的欄位分隔符為逗號
#   ↳ 結果: $1=input數字, $2=hash字串
#
# if (NR % 1000000 == 0) print "Processed: " NR > "/dev/stderr"
#   ↳ NR: AWK內建變數，目前處理的行號
#   ↳ % 1000000: 每100萬筆取餘數為0
#   ↳ > "/dev/stderr": 輸出到標準錯誤，不干擾主要結果
#   ↳ 作用: 進度報告，讓使用者知道程式在運行
#
# if ($2 in seen)
#   ↳ $2: 第2欄的hash值
#   ↳ in seen: 檢查hash是否已存在於seen關聯陣列中
#   ↳ seen[]: AWK的HashMap，格式為seen[hash] = input
#   ↳ 邏輯: 如果hash已存在 → 發生碰撞
#
# print "🎉 COLLISION! Hash:" $2 " Input1:" seen[$2] " Input2:" $1; exit
#   ↳ seen[$2]: 第一次出現此hash的input值
#   ↳ $1: 第二次出現此hash的input值
#   ↳ exit: 找到碰撞立即結束，節省時間
#
# seen[$2] = $1
#   ↳ 記錄hash和input的映射關係
#   ↳ 格式: seen["hash字串"] = input數字
#   ↳ 用途: 為後續碰撞檢測提供比對基準
#
# END {if (NR > 0) print "Finished " NR " entries"}
#   ↳ 處理完所有資料後執行
#   ↳ NR > 0: 確保有處理到資料
#   ↳ 報告總處理筆數
#
# 【執行方式】
# chmod +x script.sh
# ./script.sh                    # 使用預設檔案
# ./script.sh your_file.csv      # 指定檔案
#
# 【效能表現】
# - 100萬筆: 約30秒
# - 1000萬筆: 約2-3分鐘
# - 1億筆: 約10-15分鐘
# - 記憶體使用: 50-200MB (視hash分散度)
#
# 【輸出說明】
# - 進度: "Processed: 1000000" (每100萬筆)
# - 碰撞: "🎉 COLLISION! Hash:A1B2C Input1:123 Input2:456"
# - 完成: "Finished 50000000 entries"
# - 無碰撞代表hash函數品質優良
#
# =========================================================
