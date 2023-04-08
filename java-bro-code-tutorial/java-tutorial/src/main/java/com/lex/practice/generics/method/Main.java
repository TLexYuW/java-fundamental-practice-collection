package com.lex.practice.generics.method;

/**
 * @author : LEX_YU
 * @date : 08/04/2023
 */
public class Main {
    public static void main(String[] args) {
        // generics
        // enable types (classes and interfaces) to be parameters when defining:
        // classes, interfaces and methods
        // a benefits is to eliminate the need to create multiple versions
        // of methods or classes for various data types.
        // Use 1 version for all reference data types

        Integer[] intArr = {5, 4, 3, 2, 1};
        Double[] doubleArr = {1.2, 2.4, 3.6, 4.8, 6.0};
        Character[] charArr = {'a', 'b', 'c', 'd', 'e'};
        String[] stringArr = {"String", "This", "is", "Test"};

//        displayIntArr(intArr);
//        displayAnyArr(doubleArr);
//        displayAnyArr(charArr);
//        displayAnyArr(stringArr);

        System.out.println(getFirst(intArr));
        System.out.println(getFirst(doubleArr));
        System.out.println(getFirst(charArr));
        System.out.println(getFirst(stringArr));
    }

    // iterate every type arr like this method, inconvenient
    public static void displayIntArr(Integer[] arr) {
        for (Integer i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    // print <T> T
    public static <T> void displayAnyArr(T[] arr) {
        for (T i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    // return <T> T
    public static <T> T getFirst(T[] array){
        return array[0];
    }
}
