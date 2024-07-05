package com.lex.practice.execl.easy.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.lex.practice.execl.easy.dao.DemoDAO;
import com.lex.practice.model.DemoData;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author Jiaju Zhuang
 */
// DemoDataListener 不能被spring管理，要每次讀取excel都要new，然後裡面用到Spring可以建構方法傳進去
@Slf4j
public class DemoDataListener implements ReadListener<DemoData> {

    private static final int BATCH_COUNT = 100;

    private List<DemoData> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    private DemoDAO demoDAO;

    /**
     * For Not Spring
     */
    public DemoDataListener() {
        demoDAO = new DemoDAO();
    }

    /**
     * For Spring
     */
    public DemoDataListener(DemoDAO demoDAO) {
        this.demoDAO = demoDAO;
    }


    @Override
    public void invoke(DemoData data, AnalysisContext context) {
        System.out.println("DemoData: " + data);
        cachedDataList.add(data);
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            // Clear List
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 確保最後遺留的資料也儲存到資料庫
        saveData();
        System.out.println("所有資料解析完成！");
    }

    private void saveData() {
        System.out.printf("%d 條數據，開始儲存資料庫！\n", cachedDataList.size());
        demoDAO.save(cachedDataList);
        System.out.println("儲存資料庫成功！");
    }
}
