package com.lex.practice.init;

/**
 * @author : LEX_YU
 * @date : 2023/3/12
 * 1.所有的靜態區塊 會照順序被合併在一起(包含靜態變數宣告)
 * 2.所有的Instance Initializer 會照順序被合併在一起
 * 3.Instance Initializer 會被移到constructor之前執行
 * 跑完所有static的程式碼(類別初始化)
 * 然後跑完所有Instance Initializer(物件初始化)
 * 然後才跑constructor
 */
public class StaticOrder {
    static final int var1 = 123;
    static final int var2 = (int) (Math.random() * 10);
    {
        System.out.println("1");
    }
    static {
        System.out.println("2");
    }
    StaticOrder () {
        System.out.println("3");
    }
    {
        System.out.println("4");
    }
    static {
        System.out.println("5");
    }
    static {
        System.out.println("6");
    }
    static int a(){
        System.out.println("7");
        return 1;
    }
    static final int var3 = a();

    public static void main(String[] args) throws Exception {
        new StaticOrder();
    }
}
