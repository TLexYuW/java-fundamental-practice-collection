package com.lex.practice.logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * @author : Lex Yu
 */
public class LogFile {
    public static void main(String[] args) {
        try (FileWriter fileWriter = new FileWriter("logfile.log", true);
             BufferedWriter bw = new BufferedWriter(fileWriter)){


            while (true) {
                int value = new Random().nextInt(100) + 1;
                long timestamp = System.currentTimeMillis() / 1000L;
                String id = "stream-1";

                String response = "{\"random\":\"" + value + "\",\"timestamp\":\"" + timestamp + "\",\"id\":\"" + id + "\"}";
                bw.write(response + "\n");
                bw.flush();

                // Wait for 5 seconds
                Thread.sleep(5000);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
