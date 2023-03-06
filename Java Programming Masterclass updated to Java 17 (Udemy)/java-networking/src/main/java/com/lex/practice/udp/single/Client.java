package com.lex.practice.udp.single;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

/**
 * @author : LEX_YU
 * @date : 06/03/2023
 */
public class Client {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            DatagramSocket datagramSocket = new DatagramSocket();

            Scanner scanner = new Scanner(System.in);
            String echoString;
            do {
                System.out.println("Enter string to be echoed: ");
                echoString = scanner.nextLine();
                byte[] buffer = echoString.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address,7777);
                datagramSocket.send(packet);

                byte[] buffer2 = new byte[50];
                packet = new DatagramPacket(buffer2, buffer2.length);
                datagramSocket.receive(packet);
                System.out.println("Text received is: " + new String(buffer2, 0, packet.getLength()));
            }while (!echoString.equals("exit"));
        } catch (SocketTimeoutException ex) {
            System.out.println("The Socket Timed out");
        } catch (IOException ex){
            System.out.println("Client Error: " + ex.getMessage());
        }
    }
}
