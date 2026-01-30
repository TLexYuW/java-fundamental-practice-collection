package com.lex.practice.jvm.loader.loader2;

/**
 * @author : LEX_YU
 * @date : 2023/3/11
 */
public class Main {
    {
        System.out.println("1");
    }
    static {
        System.out.println("2");
    }
    public static void main(String[] args) throws Exception {
        System.out.println("3");
        System.out.println("4: " + Subclass.var1);
        System.out.println("5");
        System.out.println("6: " + Subclass.var2);
        System.out.println("7");
        new Subclass();
        hello();
        SuperInterface.staticMethod();
    }
    static void hello(){
        new Hello();
    }
}
interface SuperInterface {
    int STATIC_1 = printRandom();
    int STATIC_2 = printRandom();
    static void staticMethod() {
        System.out.println("16");
    }
    static int printRandom() {
        System.out.println((int)(Math.random() * 10));
        return 1;
    }
}


interface SubInterface extends SuperInterface {
    static void staticMethod() {
        System.out.println("17");
    }
}
class Superclass {
    {
        System.out.println("12");
    }
    static {
        System.out.println("13");
    }
    Superclass () {
        System.out.println("14");
    }
    {
        System.out.println("15");
    }
}
class Subclass extends Superclass implements SubInterface {
    static final int var1 = 123;
    static final int var2 = (int) (Math.random() * 10);
    {
        System.out.println("8");
    }
    static {
        System.out.println("9");
    }
    Subclass () {
        System.out.println("10");
    }
    {
        System.out.println("11");
    }
}
class Hello {
    {
        System.out.println("18");
    }
    static {
        System.out.println("19");
    }
    Hello (){
        Superclass superclass = new Subclass();
    }
    {
        System.out.println("20");
    }
}