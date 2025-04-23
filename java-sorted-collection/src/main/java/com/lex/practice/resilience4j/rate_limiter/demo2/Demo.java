package com.lex.practice.resilience4j.rate_limiter.demo2;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo {

    private static final BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>(100);
    private static final String POISON_PILL = "POISON_PILL";

    public static void main(String[] args) throws InterruptedException {
        String[] messages = new String[25];
        for (int i = 0; i < 25; i++) {
            messages[i] = "Message " + (i + 1);
        }

        // 模擬處理訊息
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    String msg = messageQueue.take();
                    if (POISON_PILL.equals(msg)) {
                        System.out.println(LocalTime.now() + " ❌ 收到結束訊號，結束消費者");
                        break;
                    }
                    System.out.println(LocalTime.now() + " ✅ 消費: " + msg);
                    Thread.sleep(500); // 模擬處理延遲
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        consumer.start();

        // Thread.sleep 模擬每秒 1 筆
        System.out.println("\n➡ Thread.sleep(1000ms) 測試開始");
        long start = System.currentTimeMillis();
        sendWithSleep(messages);
        long end = System.currentTimeMillis();
        System.out.println("Thread.sleep 總耗時: " + (end - start) + " ms");

        // Resilience4j RateLimiter 控制速率
        System.out.println("\n➡ Resilience4j RateLimiter 測試開始");
        start = System.currentTimeMillis();
        sendWithRateLimiter(messages);
        end = System.currentTimeMillis();
        System.out.println("RateLimiter 總耗時: " + (end - start) + " ms");

        // Over
        messageQueue.put(POISON_PILL);
        consumer.join();
        System.out.println("✅ 所有訊息處理完畢，程序結束");
    }

    // 每筆硬等待 1 秒
    public static void sendWithSleep(String[] messages) throws InterruptedException {
        for (String msg : messages) {
            System.out.println(LocalTime.now() + " 🚀 發送: " + msg);
            messageQueue.put(msg);
            Thread.sleep(1000);
        }
    }

    // RateLimiter 控制速率
    public static void sendWithRateLimiter(String[] messages) {
        RateLimiterConfig config = RateLimiterConfig.custom()
                .timeoutDuration(Duration.ofMillis(1000))   // 最多等待 token 時間
                .limitRefreshPeriod(Duration.ofSeconds(1))  // 每秒重新填滿 token
                .limitForPeriod(1)                          // 每秒最多 1 筆
                .build();

        RateLimiter rateLimiter = RateLimiter.of("rateLimiter", config);

        for (String msg : messages) {
            RateLimiter.waitForPermission(rateLimiter); // 等待 token
            try {
                messageQueue.put(msg); // 模擬 convertAndSend
                System.out.println(LocalTime.now() + " 🚀 發送: " + msg);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
