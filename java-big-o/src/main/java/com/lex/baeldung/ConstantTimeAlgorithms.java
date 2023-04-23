package com.lex.baeldung;

/**
 * @author : Lex Yu
 * @date : 2023/4/23
 * @last_modified : 2023/4/23
 */
public class ConstantTimeAlgorithms {
    // O(1)
    public static void main(String[] args) {
        int n = 1000;
        System.out.println("Hey - your input is: " + n);

        int x = 1000;
        System.out.println("Hey - your input is: " + x);
        System.out.println("Hmm.. I'm doing more stuff with: " + x);
        System.out.println("And more: " + x);
    }
}
