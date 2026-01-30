package com.lex.practice.solid.ocp;

/**
 * @author : Lex Yu
 * @date : 07/05/2023
 */
public interface NotificationService {
    void sendOTP(String medium);
    void sendTransactionNotification(String medium);
}
