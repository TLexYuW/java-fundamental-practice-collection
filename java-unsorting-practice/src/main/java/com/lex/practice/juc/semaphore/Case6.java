package com.lex.practice.juc.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/25
 */
public class Case6 {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(5);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Runnable task = () -> {
			boolean permit = false;
			try {
				permit = semaphore.tryAcquire(2, TimeUnit.SECONDS);
				if (permit) {
					System.out.println("Semaphore acquired : " + Thread.currentThread().getName());
					Thread.sleep(5000);
				} else {
					System.out.println("Could not acquire semaphore");
				}
			} catch (Exception ex) {
				System.out.println("err");
			} finally {
				if (permit) semaphore.release();
			}
		};
		IntStream.range(0, 10)
				.forEach(i -> {
					executorService.submit(task);
				});
		executorService.shutdown();
	}
}
