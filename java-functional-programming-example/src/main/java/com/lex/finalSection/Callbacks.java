package com.lex.finalSection;

import java.util.function.Consumer;

public class Callbacks {
    public static void main(String[] args) {
        hello("Lex",null, value ->{
            System.out.println("no lastName provided for " + value);
        });

        hello2("Lex",null, () -> System.out.println("no lastName provided"));

    }

    static void hello(String firstName, String lastName, Consumer<String> callback){
        System.out.println(firstName);
        if (lastName != null){
            System.out.println(lastName);
        }else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback){
        System.out.println(firstName);
        if (lastName != null){
            System.out.println(lastName);
        }else {
            callback.run();
        }
    }

//    JavaScript
//    function hello (String firstName, String lastName, callback){
//        console.log(firstName);
//        if (lastName){
//            console.log(lastName);
//        } else {
//            callback();
//        }
//    }


}
