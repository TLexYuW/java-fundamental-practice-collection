package com.lex.practice.loader.loader1;

/**
 * @author : LEX_YU
 * @date : 2023/3/11
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("1");
        System.out.println("2: " + Subclass.var1);
        System.out.println("3");
        System.out.println("4: " + Subclass.var2);
        System.out.println("5");
        new Subclass();
    }
}

class Superclass {
    static {
        System.out.println("9");
    }

    Superclass() {
        System.out.println("10");
    }

    {
        System.out.println("11");
    }
}

class Subclass extends Superclass {
    static final int var1 = 123;
    static final int var2 = (int) (Math.random() * 10);

    static {
        System.out.println("6");
    }

    Subclass() {
        System.out.println("7");
    }

    {
        System.out.println("8");
    }
}