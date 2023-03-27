
package com.lex.practice.high_level_api;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author : LEX_YU
 * @date : 26/03/2023
 */
public class ApacheHttp {
    public static void main(String[] args) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet("https://example.org");
            request.addHeader("User-Agent","Chrome");
            try(CloseableHttpResponse response = httpClient.execute(request)) {
                System.out.println("status code = " + response.getCode());
                BufferedReader br =  new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                while (br.readLine() != null){
                    String line = br.readLine();
                    System.out.println(line);
                }
                br.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
}
