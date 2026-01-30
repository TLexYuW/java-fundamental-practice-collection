package com.lex.practice.guava.rate_limiter;


import com.google.common.util.concurrent.RateLimiter;

import static com.lex.practice.util.Utils.formatter;

/**
 * @author : Lex Yu
 */
public class Demo {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(5.0);

        for (int i = 0; i < 20; i++) {
            rateLimiter.acquire();
            System.out.println("Operation " + (i + 1) + " executed at " + formatter(System.currentTimeMillis()));
        }
    }
}
