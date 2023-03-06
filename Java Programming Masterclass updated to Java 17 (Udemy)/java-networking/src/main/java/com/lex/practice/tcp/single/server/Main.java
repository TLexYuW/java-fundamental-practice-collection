package com.lex.practice.tcp.single.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : LEX_YU
 * @date : 28/02/2023
 * Server use I/O send and receive data from client
 */
public class Main {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8888)) {
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected...");

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
            PrintWriter writer = new PrintWriter(osw, true);

            while (true){
                String echoString = br.readLine();
                if (echoString.equals("exit")) {
                    break;
                }
                writer.println("Echo from server: " + echoString);
            }
        } catch (Exception ex) {
            System.out.println("Server Exception " + ex.getMessage());
        }
    }
}