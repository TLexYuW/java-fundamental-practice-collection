package com.lex.practice.high_level_api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author : LEX_YU
 * @date : 26/03/2023
 */
public class Main4 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.flickr.com/services/feeds/photos_public.gne?tags=cats");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");

            int statusCode = connection.getResponseCode();
            System.out.println("Response Code: " + statusCode);

            if (statusCode != 200){
                System.out.println("Error reading web page");
                System.out.println(connection.getResponseMessage());
                return;
            }

            connection.setReadTimeout(30_000);

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while (br.readLine() != null){
                String line = br.readLine();
                System.out.println(line);
            }
            br.close();

            Map<String, List<String>> headerFields = connection.getHeaderFields();

            Set<String> set = headerFields.keySet();
            Iterator<String> it = set.iterator();
            while (it.hasNext()){
                String key = it.next();
                System.out.printf("%s=%s\n", key, headerFields.get(key));
            }

        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
