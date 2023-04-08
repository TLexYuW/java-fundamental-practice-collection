package com.lex.practice.generics.cls;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author : LEX_YU
 * @date : 2023/4/8
 * @last_modified_date : 2023-2023/4/8
 */
public class Main3 {
    public static void main(String[] args) {
        // bounded types
        // you can create the objects of a generic class to have data
        // of specific derived types
        // ex. class MyGenericClass<T extends Number, T2 extends Number>



        /*
        MyIntClass myIntClass = new MyIntClass(1);
        MyDoubleClass myDoubleClass = new MyDoubleClass(5.5);
        MyCharacterClass myCharacterClass = new MyCharacterClass('A');
        MyStrClass myStrClass = new MyStrClass("str");
        System.out.println(myIntClass.getValue());
        System.out.println(myDoubleClass.getValue());
        System.out.println(myCharacterClass.getValue());
        System.out.println(myStrClass.getValue());
         */

        MyGenericClass<Integer, Integer> myIntClass = new MyGenericClass<>(1, 7);
        MyGenericClass<Double, Double> myDoubleClass = new MyGenericClass<>(5.5, 9.8);
//        MyGenericClass<Character, Character> myCharacterClass = new MyGenericClass<>('A', '#');
//        MyGenericClass<String, Character> myStrClass = new MyGenericClass<>("str", '!');

        ArrayList<MyGenericClass> myArr = new ArrayList<>();
        myArr.add(myIntClass);
        myArr.add(myDoubleClass);
//        myArr.add(myCharacterClass);
//        myArr.add(myStrClass);
        myArr.forEach(x -> System.out.println(x.getValueT() + ", " + x.getValueT2()));

        System.out.println("---------------------------------------------------------");

        System.out.println(myIntClass.getValueT() + ", " + myIntClass.getValueT2());
        System.out.println(myDoubleClass.getValueT() + ", " + myDoubleClass.getValueT2());
//        System.out.println(myCharacterClass.getValueT() + ", " + myCharacterClass.getValueT2());
//        System.out.println(myStrClass.getValueT() + ", " + myStrClass.getValueT2());
    }
}
