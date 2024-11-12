package com.lex.practice.math.big_decimal.number_type_compared;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberTypeComparisonDemo {
    public static void main(String[] args) {
        IntegerComparedDemo();

        System.out.println("===================================================================================");

        DoubleComparedDemo();

        System.out.println("===================================================================================");

        FloatComparedDemo();
    }

    /**
     * 基本乘法問題 <br/>
     * 連續計算 <br/>
     * 除法問題 <br/>
     * 四捨五入問題 <br/>
     */
    private static void DoubleComparedDemo() {
        // 基本乘法問題
        System.out.println("1. 基本乘法：");
        double price1 = 9.99;
        double quantity1 = 3;
        System.out.printf("   Double: %.20f * %d = %.20f%n", price1, (int)quantity1, (price1 * quantity1));

        BigDecimal bdPrice1 = new BigDecimal("9.99");
        BigDecimal bdQuantity1 = new BigDecimal("3");
        System.out.println("   BigDecimal: " + bdPrice1 + " * " + bdQuantity1 + " = " +
                bdPrice1.multiply(bdQuantity1));

        System.out.println("\n2. 較複雜的乘法：");
        double price2 = 4.35;
        double quantity2 = 3;
        System.out.printf("   Double: %.20f * %d = %.20f%n", price2, (int)quantity2, (price2 * quantity2));

        BigDecimal bdPrice2 = new BigDecimal("4.35");
        BigDecimal bdQuantity2 = new BigDecimal("3");
        System.out.println("   BigDecimal: " + bdPrice2 + " * " + bdQuantity2 + " = " +
                bdPrice2.multiply(bdQuantity2));

        // 連續計算
        System.out.println("\n3. 連續計算：");
        double price3 = 10.1;
        double total1 = 0;
        for (int i = 0; i < 10; i++) {
            total1 += price3;
        }
        System.out.printf("   Double 連續加法: %.20f%n", total1);

        BigDecimal bdPrice3 = new BigDecimal("10.1");
        BigDecimal total2 = BigDecimal.ZERO;
        for (int i = 0; i < 10; i++) {
            total2 = total2.add(bdPrice3);
        }
        System.out.println("   BigDecimal 連續加法: " + total2);

        // 除法問題
        System.out.println("\n4. 除法計算：");
        double price4 = 10.00;
        double divisor = 3;
        System.out.printf("   Double: %.20f / %d = %.20f%n", price4, (int)divisor, (price4 / divisor));

        BigDecimal bdPrice4 = new BigDecimal("10.00");
        BigDecimal bdDivisor = new BigDecimal("3");
        System.out.println("   BigDecimal: " + bdPrice4 + " / " + bdDivisor + " = " +
                bdPrice4.divide(bdDivisor, 10, RoundingMode.HALF_UP));

        // 四捨五入問題
        System.out.println("\n5. 四捨五入：");
        double price5 = 11.395;
        System.out.printf("   Double: %.2f%n", price5);

        BigDecimal bdPrice5 = new BigDecimal("11.395");
        System.out.println("   BigDecimal: " + bdPrice5.setScale(2, RoundingMode.HALF_UP));
    }

    /**
     * Float的精度問題
     */
    private static void FloatComparedDemo() {
        System.out.println("\n7. Float的精度問題：");
        float f1 = 123456.789f;
        System.out.println("   Float: 123456.789 = " + f1);

        BigDecimal bdf1 = new BigDecimal("123456.789");
        System.out.println("   BigDecimal: 123456.789 = " + bdf1);
    }

    /**
     * 整數溢出問題
     */
    private static void IntegerComparedDemo() {
        System.out.println("1. Integer 溢出問題：");
        int maxInt = Integer.MAX_VALUE;
        System.out.println("   Integer.MAX_VALUE: " + maxInt);
        System.out.println("   Integer.MAX_VALUE + 1: " + (maxInt + 1));  // 溢出變負數

        // 使用 BigDecimal 解決溢出
        BigDecimal bigMaxInt = new BigDecimal(Integer.MAX_VALUE);
        System.out.println("   使用BigDecimal: " + bigMaxInt.add(BigDecimal.ONE));
    }
}
