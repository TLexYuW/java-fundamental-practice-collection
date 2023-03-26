package com.lex.practice.high_level_api;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author : LEX_YU
 * @date : 26/03/2023
 */
public class Main2 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.org");
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.connect();

//            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();

            Set<String> set = headerFields.keySet();
            Iterator<String> it = set.iterator();
            while (it.hasNext()){
                String key = it.next();
                System.out.printf("%s=%s\n", key, headerFields.get(key));
            }

            /*
            for (Map.Entry<String,List<String>> entry : headerFields.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                System.out.println("key = " + key);
                for (String str : value) {
                    System.out.println("value = " + str);
                }
            }
            */

            /*
            String line = "";
            while (line != null){
                line = br.readLine();
                System.out.println(line);
            }
            br.close();
             */

            /*
            URI uri = url.toURI();
            System.out.println("Scheme = " + uri.getScheme());
            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
            System.out.println("Authority = " + uri.getAuthority());
            System.out.println("User info = " + uri.getUserInfo());
            System.out.println("Host = " + uri.getHost());
            System.out.println("Port = " + uri.getPort());
            System.out.println("Path = " + uri.getPath());
            System.out.println("Query = " + uri.getQuery());
            System.out.println("Fragment = " + uri.getFragment());
             */

        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
