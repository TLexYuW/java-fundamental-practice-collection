package com.lex.practice.callback.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author : Lex Yu
 */
public class InvokeCallback {
    public static void main(String[] args) throws InterruptedException {
        final Request request = new Request();
        new Thread(() -> {
            try {
                request.send(Callback.class, Callback.class.getMethod("process"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();

        System.out.println("Send Completed!");

        Thread.sleep(1000 * 1000);
    }
}

class Request {
    public void send(Class<Callback> callbackClass, Method method) throws Exception {
        Thread.sleep(3000);
        System.out.println("Receive Response");
        Constructor<Callback> constructor = callbackClass.getDeclaredConstructor();
        method.invoke(constructor.newInstance());
    }
}

class Callback {
    public void process() {
        System.out.println("Process Response");
    }
}