package com.lex.practice.map;

import java.util.HashMap;

/**
 * @author : LEX_YU
 * @date : 14/03/2023
 */
public class Main {
    public static void main(String[] args) {
        // HashMap implements the Map interface (need import)
        // HashMap is similar to ArrayList, but with key-values pairs
        // stores objects, need to use Wrapper Class
        // ex: (name, email), (username,userID), (country,capital)

        HashMap<String, String> countries = new HashMap<>();
        // add a key and value
        countries.put("USA","Washington DC");
        countries.put("India","New Delhi");
        countries.put("Japan","Tokyo");
        countries.put("Taiwan","Taipei");

        for (String s : countries.keySet()) {
            System.out.println(s);
            System.out.println(countries.get(s));
        }

        System.out.println(countries.size());

        System.out.println(countries.keySet());

        System.out.println(countries.entrySet());

        countries.replace("USA","Detroit");

        System.out.println(countries.containsKey("England"));

        System.out.println(countries);

        countries.remove("USA");
        System.out.println(countries);

        System.out.println(countries.get("Taiwan"));







        countries.clear();
        System.out.println(countries);


    }
}
