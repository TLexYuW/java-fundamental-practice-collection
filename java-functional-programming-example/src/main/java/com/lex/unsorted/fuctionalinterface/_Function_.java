package com.lex.unsorted.fuctionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function_ {
    public static void main(String[] args) {
        int increment = incrementByOne(1);
        System.out.println(increment);

        int increment2 = incrementByOneFunc.apply(1);
        System.out.println(increment2);

        int multiply = multipleBy10Func.apply(increment2);
        System.out.println(multiply);

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunc.andThen(multipleBy10Func);
        System.out.println("Function result: " + addBy1AndThenMultiplyBy10.apply(4));

        // BiFunction takes 2 argument and produces 1 result
        System.out.println(incrementByOneAndMultiply(4,100));
        System.out.println("BiFunction result: " + incrementByOneAndMultiplyBiFunc.apply(4,100));
    }

    static Function<Integer, Integer> incrementByOneFunc =
            num -> num + 1;

    static Function<Integer, Integer> multipleBy10Func = number -> number * 10;

    // incrementByOne same as incrementByOneFunc
    static int incrementByOne(int num){
        return num+1;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunc =
            (numberToIncrementByOne, numberToMultiplyBy)
                    -> (numberToIncrementByOne+1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int num, int numToMultiplyBy){
        return (num+1) * numToMultiplyBy;
    }

}
