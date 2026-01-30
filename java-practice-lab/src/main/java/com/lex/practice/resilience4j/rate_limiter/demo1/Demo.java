package com.lex.practice.resilience4j.rate_limiter.demo1;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;

import java.time.Duration;

import static com.lex.practice.util.Utils.formatter;

/**
 * @author : Lex Yu
 */
public class Demo {
    public static void main(String[] args) {
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitForPeriod(5)
                .limitRefreshPeriod(Duration.ofSeconds(1))
                .timeoutDuration(Duration.ofMillis(500))
                .build();

        RateLimiter rateLimiter = RateLimiter.of("myRateLimiter", config);

        for (int i = 0; i < 20; i++) {
            if (rateLimiter.acquirePermission()) {
                System.out.println("Operation " + (i + 1) + " executed at " + formatter(System.currentTimeMillis()));
            } else {
                System.out.println("Rate limit exceeded, please try again later.");
            }
        }
    }
}
