package com.lex.practice.math;

import java.time.Duration;

public class Demo {
    public static void main(String[] args) {
        int val = Math.toIntExact(Duration.ofHours(24).toMinutes());
        System.out.println(val);
    }
}
