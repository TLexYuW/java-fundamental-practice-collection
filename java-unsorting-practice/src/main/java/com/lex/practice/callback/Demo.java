package com.lex.practice.callback;

/**
 * @author : Lex Yu
 */
public class Demo {
    public static void main(String[] args) {
        Producer producer = new Producer();
        String msg = "hello";

        producer.send(msg, 0, new Callback() {
            @Override
            public void success() {
                System.out.println("Send Successfully!");
            }

            @Override
            public void fail() {
                System.out.println("Send Failed!");
            }
        });
    }
}

interface Callback {
    void success();

    void fail();
}

class Producer {
    public void send(String msg, int ack, Callback callback) {
        System.out.println("send msg : " + msg);
        if (ack == 0) {
            callback.success();
        } else {
            callback.fail();
        }
    }
}

