package com.lex.practice.networking.low_level_api.tcp.multiple.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author : LEX_YU
 * @date : 28/02/2023
 */
public class Echoer extends Thread {
    private Socket socket;

    public Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
            PrintWriter writer = new PrintWriter(osw, true);

            while (true) {
                String str = br.readLine();
                System.out.println("Received Client : " + str );
                if (str.equals("exit")) {
                    break;
                }
//                /*
                try {
                    Thread.sleep(15000);
                } catch (Exception ex) {
                    System.out.println("Thread interrupted");
                }
//                 */
                writer.println(str);
            }

        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        } finally {
            try {
                socket.close();
            } catch (Exception ex) {

            }
        }
    }
}
