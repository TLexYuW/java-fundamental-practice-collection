package com.lex.practice.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author : LEX_YU
 * @date : 24/03/2023
 */
public class Origin {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        IntStream.range(0,1000)
                .forEach(i -> executor.submit(Origin::increment));
        Thread.sleep(5_000);
        System.out.println(count);
        executor.shutdown();
    }

    static void increment() {
        count += 1;
    }
}
