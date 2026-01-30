package com.lex.practice.aws.kinesis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lex.practice.aws.kinesis.utils.KdsUtils;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.auth.credentials.SystemPropertyCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.kinesis.KinesisClient;
import software.amazon.awssdk.services.kinesis.KinesisClientBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : Lex Yu
 */
public class Main {
	private static final AtomicInteger COUNT = new AtomicInteger(0);

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(100);
		ThreadPoolExecutor customThreadPoolExecutor = new ThreadPoolExecutor(5, 5,
				30L, TimeUnit.SECONDS, arrayBlockingQueue,
				Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

		KinesisClient client = KinesisClient.builder()
				.region(Region.AP_SOUTHEAST_1)
				.credentialsProvider(ProfileCredentialsProvider
						.builder()
						.profileName("kinesisuser")
						.build())
				.build();


		long start = System.nanoTime();

		for (int i = 1; i <= 10; i++) {
			int finalI = i;
			customThreadPoolExecutor.execute(() -> {
				for (int j = 1; j <= 1_000_000; j++) {
					int total = COUNT.incrementAndGet();
					System.out.println("t" + finalI);
					System.out.println("Thread = " + Thread.currentThread().getName() + ", Total = " + total);
				}
			});
		}
		customThreadPoolExecutor.shutdown();

		customThreadPoolExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

		long end = System.nanoTime();
		double time = ((end - start) / 1000000000.0);  // 将纳秒转换为秒

		System.out.println("Time cost = " + time + "s");
	}
}
