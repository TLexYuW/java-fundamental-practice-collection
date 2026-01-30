package com.lex.practice.jvm.init;

/**
 * @author : LEX_YU
 * @date : 2023/3/12
 */
public class ClassInitialization {
    {
        System.out.println("ClassInitialization: 1");
    }
    static {
        System.out.println("ClassInitialization static: 2"); // ClassInitialization, no.1
    }
    public static void main(String[] args) throws Exception {
        System.out.println("psvm: 3"); // compile-time constants, no.2
        System.out.println("psvm: 4: " + Subclass.var1); // compile-time constants, no.3
        System.out.println("psvm: 5"); // no.4
        System.out.println("psvm: 6: " + Subclass.var2); // no.7
        System.out.println("psvm: 7"); // no.8
        new Subclass();
        hello();
        SuperInterface.staticMethod();
    }
    static void hello(){
        new Hello();
    }
}
interface SuperInterface {
    int STATIC_1 = printRandom(); // no.24
    int STATIC_2 = printRandom(); // no.25
    static void staticMethod() {
        System.out.println("SuperInterface staticMethod: 16"); // no.26
    }
    static int printRandom() {
        System.out.println("SuperInterface static method printRandom : " + (int)(Math.random() * 10));
        return 1;
    }
}


interface SubInterface extends SuperInterface {
    static void staticMethod() {
        System.out.println("SubInterface static method 17");
    }
}
class Superclass {
    {
        System.out.println("Superclass 12"); // no.9, no.18
    }
    static {
        System.out.println("Superclass static 13"); // no.5
    }
    Superclass () {
        System.out.println("Superclass constructor 14"); // no.11, no.20
    }
    {
        System.out.println("Superclass 15"); // no.10, no.19
    }
}
class Subclass extends Superclass implements SubInterface {
    static final int var1 = 123; // no.3
    static final int var2 = (int) (Math.random() * 10); // no.7
    {
        System.out.println("Subclass 8"); // no.12, no.21
    }
    static {
        System.out.println("Subclass static 9"); // no.6
    }
    Subclass () {
        System.out.println("Subclass constructor 10"); // no.14, no.23
    }
    {
        System.out.println("Subclass 11"); // no.13, no.22
    }
}
class Hello {
    {
        System.out.println("Hello 18"); // no.16
    }
    static {
        System.out.println("Hello static 19"); // init..., no.15
    }
    Hello (){
        Superclass superclass = new Subclass();
    }
    {
        System.out.println("Hello 20"); // no.17
    }
}