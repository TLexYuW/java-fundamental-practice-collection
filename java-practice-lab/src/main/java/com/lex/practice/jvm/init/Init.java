package com.lex.practice.jvm.init;

/**
 * @author : LEX_YU
 * @date : 2023/3/12
 * VM option: -verbose:class
 */
public class Init {
    public static void main(String[] args) {
        Initialize initialize = new Initialize();
        System.out.println(initialize);
    }
}

class Initialize {

//    /*
    static int i;
    static {
        i = 122;
        System.out.println(i);
    }
    static {
        i = 123;
        System.out.println(i);
    }
//     */
    /*
    static {
        i = 122;
        System.out.println(i);//illegal forward reference
    }
    static int i;
     */
    /*
    static {
        i = 122;
    }

    static int i;

    static {
        System.out.println(i);
    }
     */
}
