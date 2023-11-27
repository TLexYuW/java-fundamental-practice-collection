package com.lex.practice.callback.inter_face;


/**
 * @author : Lex Yu
 */
public class InterfaceCallback {
    public static void main(String[] args) throws InterruptedException {
        final Request request = new Request();
        System.out.println("Send Request!");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    request.send(new ResponseCallback() {
                        @Override
                        public void process() {
                            System.out.println("Receive Response!");
                        }
                    });
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
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
