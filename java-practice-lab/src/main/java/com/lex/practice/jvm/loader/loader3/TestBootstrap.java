package com.lex.practice.jvm.loader.loader3;

/**
 * @author : LEX_YU
 * @date : 2023/3/11
 */
public class TestBootstrap {
    public static void main(String[] args) {

        ClassLoader cl = new CustomClassLoader();
        while (cl!=null){
            System.out.println(cl);
            cl = cl.getParent();
            /*
            PlatformClassLoader JDK 9 後取代 ExtClassLoader
             */
            System.out.println(cl);
        }
    }
    private static class CustomClassLoader extends ClassLoader {}
}
