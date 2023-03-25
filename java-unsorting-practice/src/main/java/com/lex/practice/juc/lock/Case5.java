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
		StampedLock lock = new StampedLock();
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		executorService.submit(() -> {
           long stamp = lock.tryOptimisticRead();
		   try {
			   System.out.println("Optimistic Lock Valid: " +  lock.validate(stamp));
			   Thread.sleep(2000);
			   System.out.println("Optimistic Lock Valid: " +  lock.validate(stamp));
			   Thread.sleep(2000);
			   System.out.println("Optimistic Lock Valid: " +  lock.validate(stamp));
		   } catch (InterruptedException e) {
			   System.out.println("err");
		   } finally {
		       lock.unlock(stamp);
		   }
		});

		executorService.submit(() -> {
			long stamp = lock.writeLock();
			try {
				System.out.println("Write Lock Acquired");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("err");
			} finally {
				System.out.println("Write Done");
				lock.unlock(stamp);
			}
		});


		executorService.shutdown();
	}
}
