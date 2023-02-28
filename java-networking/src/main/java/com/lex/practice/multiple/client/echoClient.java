package com.lex.practice.multiple.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author : LEX_YU
 * @date : 28/02/2023
 * Client
 */
public class echoClient {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",8888)) {
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
            PrintWriter writer = new PrintWriter(osw, true);

            Scanner scanner = new Scanner(System.in);
            String inputStr;
            String response;
            do {
                System.out.println("Enter string to be echoed : ");
                inputStr = scanner.nextLine();
                writer.println(inputStr);
                if (!inputStr.equals("exit")) {
                    response = br.readLine();
                    System.out.println(response);
                }
            } while (!inputStr.equals("exit"));

        } catch (Exception ex) {
            System.out.println("Client Error : " + ex.getMessage());
        }
    }
}
