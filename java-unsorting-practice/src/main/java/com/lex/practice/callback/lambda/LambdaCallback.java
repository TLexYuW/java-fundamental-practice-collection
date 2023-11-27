package com.lex.practice.callback.lambda;

/**
 * @author : Lex Yu
 */
public class LambdaCallback {
    public static void main(String[] args) throws InterruptedException {
        final Request request = new Request();
        System.out.println("Send Request!");

        new Thread(() -> {
            try {
                request.send(() -> System.out.println("Receive Response!"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        System.out.println("Send Completed!");

        Thread.sleep(10000);
    }
}

interface ResponseCallback {
    void process();
}

class Request {
    public void send(ResponseCallback callback) throws InterruptedException {
        Thread.sleep(3000);

        callback.process();
    }
}
