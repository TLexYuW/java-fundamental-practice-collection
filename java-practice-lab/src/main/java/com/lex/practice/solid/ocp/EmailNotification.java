package com.lex.practice.solid.ocp;

/**
 * @author : Lex Yu
 * @date : 07/05/2023
 */
public class EmailNotification implements NotificationService{
    @Override
    public void sendOTP(String medium) {
        // write Logic using JavaEmail api
    }

    @Override
    public void sendTransactionNotification(String medium) {

    }
}
