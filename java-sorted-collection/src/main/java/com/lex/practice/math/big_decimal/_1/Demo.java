package com.lex.practice.math.big_decimal._1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Demo {
    public static void main(String[] args) {
        // 1. 建立 BigDecimal
        BigDecimal num1 = new BigDecimal("10.5");
        BigDecimal num2 = new BigDecimal("3");
        BigDecimal num3 = BigDecimal.valueOf(10.5);
        System.out.println("1. 初始值：");
        System.out.println("   num1 = " + num1);
        System.out.println("   num2 = " + num2);
        System.out.println("   num3 = " + num3);

        // 2. 基本運算
        BigDecimal sum = num1.add(num2);
        BigDecimal diff = num1.subtract(num2);
        BigDecimal product = num1.multiply(num2);
        BigDecimal quotient = num1.divide(num2, 2, RoundingMode.HALF_UP);

        System.out.println("\n2. 基本運算：");
        System.out.println("   加法 (num1 + num2) = " + sum);
        System.out.println("   減法 (num1 - num2) = " + diff);
        System.out.println("   乘法 (num1 * num2) = " + product);
        System.out.println("   除法 (num1 / num2) = " + quotient);

        // 3. 比較操作
        boolean isEqual = num1.equals(num3);
        int compareResult = num1.compareTo(num2);
        System.out.println("\n3. 比較操作：");
        System.out.println("   num1 是否等於 num3: " + isEqual);
        System.out.println("   num1 比較 num2 結果: " + compareResult);

        // 4. 取值和轉換
        int intValue = num1.intValue();
        double doubleValue = num1.doubleValue();
        String strValue = num1.toString();
        System.out.println("\n4. 值轉換：");
        System.out.println("   轉換為整數: " + intValue);
        System.out.println("   轉換為浮點數: " + doubleValue);
        System.out.println("   轉換為字串: " + strValue);

        // 5. 四捨五入和精度控制
        BigDecimal rounded = num1.setScale(2, RoundingMode.HALF_UP);
        BigDecimal truncated = num1.setScale(0, RoundingMode.DOWN);
        System.out.println("\n5. 精度控制：");
        System.out.println("   四捨五入到2位小數: " + rounded);
        System.out.println("   直接捨去小數位: " + truncated);

        // 6. 取絕對值和相反數
        BigDecimal negative = new BigDecimal("-10.5");
        BigDecimal abs = negative.abs();
        BigDecimal negated = num1.negate();
        System.out.println("\n6. 絕對值和相反數：");
        System.out.println("   原始負數: " + negative);
        System.out.println("   絕對值: " + abs);
        System.out.println("   num1的相反數: " + negated);

        // 7. 判斷特殊值
        boolean isZero = num1.signum() == 0;
        boolean isPositive = num1.signum() > 0;
        boolean isNegative = num1.signum() < 0;
        System.out.println("\n7. 數值判斷：");
        System.out.println("   是否為零: " + isZero);
        System.out.println("   是否為正數: " + isPositive);
        System.out.println("   是否為負數: " + isNegative);

        // 8. 取最大最小值
        BigDecimal max = num1.max(num2);
        BigDecimal min = num1.min(num2);
        System.out.println("\n8. 最大最小值：");
        System.out.println("   最大值: " + max);
        System.out.println("   最小值: " + min);

        // 9. 次方運算
        BigDecimal squared = num1.pow(2);
        System.out.println("\n9. 次方運算：");
        System.out.println("   num1的平方: " + squared);

        // 10. 移動小數點
        BigDecimal moved = num1.movePointLeft(2);
        BigDecimal moved2 = num1.movePointRight(1);
        System.out.println("\n10. 小數點移動：");
        System.out.println("    左移2位: " + moved);
        System.out.println("    右移1位: " + moved2);
    }
}
