package com.lex.practice.solid.ocp;

/**
 * @author : Lex Yu
 * @date : 07/05/2023
 */
public class MobileNotification implements NotificationService{
    @Override
    public void sendOTP(String medium) {
        // write Logic using XXX SMS API
    }

    @Override
    public void sendTransactionNotification(String medium) {

    }
}
