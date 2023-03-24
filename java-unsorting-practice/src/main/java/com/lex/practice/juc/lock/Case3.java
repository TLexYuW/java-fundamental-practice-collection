package com.lex.practice.juc.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author : LEX_YU
 * @date : 24/03/2023
 */
public class Case3 {
    private static int count = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        Executors.newSingleThreadExecutor().submit(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName());
                System.out.println("=================================");
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println("err");
            } finally {
                lock.unlock();
            }
        });
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            System.out.println("Locked: " + lock.isLocked());
            System.out.println("Held by this thread: " + lock.isHeldByCurrentThread());
            boolean locked = lock.tryLock();
            System.out.println("Lock acquired: " + locked);
            System.out.println(Thread.currentThread().getName());
            System.out.println("=======================================");
        }, 0, 1, TimeUnit.SECONDS);
    }
}
