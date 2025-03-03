package com.lex.practice.networking.low_level_api.tcp.multiple.server;

import com.lex.practice.networking.low_level_api.tcp.multiple.client.Echoer;

import java.net.ServerSocket;

/**
 * @author : LEX_YU
 * @date : 28/02/2023
 * Server use I/O send and receive data from client
 * can make multiple client connected
 */
public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            while (true) {
                /*
                InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                BufferedReader br = new BufferedReader(isr);

                OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
                PrintWriter writer = new PrintWriter(osw, true);

                String echoString = br.readLine();
                try {
                    Thread.sleep(15000);
                } catch (Exception ex) {
                    System.out.println("Thread interrupted ...");
                }
                if (echoString.equals("exit")) {
                    break;
                }
                writer.println("Echo from server: " + echoString);
                 */

                new Echoer(serverSocket.accept()).start();
                /*
                Socket socket = serverSocket.accept();
                Echoer echoer = new Echoer(socket);
                echoer.start();
                 */
                System.out.println("Client Connected...");

            }


        } catch (Exception ex) {
            System.out.println("Server Exception " + ex.getMessage());
        }
    }
}