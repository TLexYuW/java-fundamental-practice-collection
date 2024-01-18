
package com.lex.practice.networking.high_level_api.apache;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

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
                System.out.println("status code = " + response.getStatusLine().getStatusCode());
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
