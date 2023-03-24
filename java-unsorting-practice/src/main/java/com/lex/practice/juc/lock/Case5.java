package com.lex.practice.juc.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * @author : LEX_YU
 * @date : 24/03/2023
 */
public class Case5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        StampedLock lock = new StampedLock();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable writeTask = () -> {
            long stamp = lock.writeLock();
            System.out.println("writeTask: " + Thread.currentThread().getName());
            try {
                list.add("Things");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("err");
            } finally {
                System.out.println(stamp);
                lock.unlockWrite(stamp);
            }
        };

        Runnable readTask = () -> {
            long stamp = lock.readLock();
            System.out.println("readTask: " + Thread.currentThread().getName());
            try {
                System.out.println(list.get(0));
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("err");
            } finally {
                System.out.println(stamp);
                lock.unlockRead(stamp);
            }
        };

        executorService.submit(writeTask);
        executorService.submit(readTask);
        executorService.submit(readTask);

        executorService.shutdown();
    }
}
