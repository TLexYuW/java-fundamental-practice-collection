package com.lex.practice.reactive.essentials.mono;

/**
 * @author : Lex Yu
 * Reactive Streams
 * 1. Asynchronous
 * 2. Non-blocking
 * 3. Backpressure
 * Publisher <- (subscribe) Subscriber
 * Subscription is created
 * Publisher (OnSubscribe with the subscription) -> Subscriber
 * Subscription <- (request N) Subscriber
 * Publisher -> (onNext) Subscriber
 * until:
 * 1. Publisher sends all the objects requested
 * 2. Publisher sends all the objects it has. (onCompleted) subscriber and subscription will be canceled
 * 3. There is an error. (onError) ->  subscriber and subscription will be canceled
 */
public class MonoTest {
}
