package com.lex.practice.juc.synchronize;

import com.lex.practice.juc.Origin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author : LEX_YU
 * @date : 24/03/2023
 */
public class Case1 {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        IntStream.range(0,1000)
                .parallel()
                .forEach(i -> {
                    System.out.println(Thread.currentThread().getName());
                    executor.submit(Case1::increment);
                });
        Thread.sleep(5_000);
        System.out.println(count);
        executor.shutdown();
    }

    static synchronized void increment() {
        count += 1;
    }
}
