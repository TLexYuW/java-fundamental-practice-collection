package com.lex.practice;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : LEX_YU
 * @date : 01/03/2023
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        // Cat fields are private, and we can't access it
        Cat myCat = new Cat("L",8);
        System.out.println("Original Name : " + myCat.getName());

        // With reflection help, we can
        Field[] catFields = myCat.getClass().getDeclaredFields();
        for (Field field : catFields) {
//            System.out.println(field.getName());
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(myCat, "Reflection Set New Name");
            }
        }
        System.out.println("Reflection Name : " + myCat.getName() + "\n");

        // ----- Method
        Method[] catMethods = myCat.getClass().getDeclaredMethods();
        for (Method m : catMethods) {
            // call private static method
            if (m.getName().equals("thisIsPrivateStaticMethod")) {
                m.setAccessible(true);
                m.invoke(null);
            }
            // call public static method
//            if (m.getName().equals("thisIsPublicStaticMethod")) {
//                m.setAccessible(true);
//                m.invoke(null);
//            }
            // Private method
//            if (m.getName().equals("heyThisIsPrivate")) {
//                m.setAccessible(true);
//                m.invoke(myCat);
//            }
            // public
//            if (m.getName().equals("meow")) {
//                m.invoke(myCat);
//                myCat.meow();
//            }
//            System.out.println(m.getName());
        }
    }
}
