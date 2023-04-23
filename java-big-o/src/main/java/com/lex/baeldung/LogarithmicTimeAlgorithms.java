package com.lex.baeldung;

/**
 * @author : Lex Yu
 * @date : 2023/4/23
 * @last_modified : 2023/4/23
 */
public class LogarithmicTimeAlgorithms {
    // O(log n)
    public static void main(String[] args) {
        int n = 1000000000;
        for (int i = 1; i < n; i = i * 2){
            System.out.println("Hey - I'm busy looking at: " + i);
        }
    }
}
