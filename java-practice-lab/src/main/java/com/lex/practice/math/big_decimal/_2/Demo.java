package com.lex.practice.math.big_decimal._2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Demo {
    public static void main(String[] args) {
        // 1. 創建一個非常大的數
        BigDecimal veryLargeNumber = new BigDecimal("1").pow(100000);
        System.out.println("1. 大數示範：");
        System.out.println("   10的100000次方：" + veryLargeNumber);

        // 2. 創建一個非常小的數
        BigDecimal verySmallNumber = new BigDecimal("0.1").pow(100);
        System.out.println("\n2. 小數示範：");
        System.out.println("   0.1的100次方：" + verySmallNumber);

        // 3. 高精度計算示範
        BigDecimal num1 = new BigDecimal("1");
        BigDecimal num2 = new BigDecimal("3");

        // 除法計算，設定100位小數
        BigDecimal result = num1.divide(num2, 100, RoundingMode.HALF_UP);
        System.out.println("\n3. 高精度除法（1/3，保留100位小數）：");
        System.out.println("   " + result);

        // 4. 科學記號表示
        BigDecimal scientificNotation = new BigDecimal("1.23456789E+50");
        System.out.println("\n4. 科學記號表示：");
        System.out.println("   " + scientificNotation.toPlainString());

        // 5. 常見的金融計算精度（一般使用2-4位小數）
        BigDecimal amount = new BigDecimal("1234.56789");
        System.out.println("\n5. 常見金融計算精度：");
        System.out.println("   原始數值：" + amount);
        System.out.println("   2位小數：" + amount.setScale(2, RoundingMode.HALF_UP));
        System.out.println("   4位小數：" + amount.setScale(4, RoundingMode.HALF_UP));
    }
}
