package com.lex.practice.solid.srp;

/**
 * @author : Lex Yu
 * @date : 07/05/2023
 */
public class NotificationService {

    // SITUATION: medium is email, mobile, some-app, etc...
    // TODO: OCP
    public void sendOTP(String medium) {
        if (medium.equals("email")) {
            //write email related logic
            //use JavaMailSenderAPI
        }
    }
}
