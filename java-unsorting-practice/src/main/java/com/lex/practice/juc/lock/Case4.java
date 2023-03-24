package com.lex.practice.juc.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : LEX_YU
 * @date : 24/03/2023
 */
public class Case4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable writeTask = () -> {
            lock.writeLock().lock();
            System.out.println("writeTask: " + Thread.currentThread().getName());
            try {
                list.add("Things");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("err");
            } finally {
                lock.writeLock().unlock();
            }
        };

        Runnable readTask = () -> {
            lock.readLock().lock();
            System.out.println("readTask: " + Thread.currentThread().getName());
            try {
                System.out.println(list.get(0));
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("err");
            } finally {
                lock.readLock().unlock();
            }
        };

        executorService.submit(writeTask);
        executorService.submit(readTask);
        executorService.submit(readTask);

        executorService.shutdown();
    }
}
