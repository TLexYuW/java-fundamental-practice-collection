package com.lex.practice.high_level_api;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author : LEX_YU
 * @date : 07/03/2023
 * URL、URI
 */
public class Main {
    public static void main(String[] args) {
        try {
//            URI uri = new URI("db://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
//            URI uri = new URI("https://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
            URI baseUri = new URI("https://username:password@myserver.com:5000");
            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
            URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
            URI uri3 = new URI("/stores/locations?zip=12345");
            URI resolvedUri1 = baseUri.resolve(uri1);
            URI resolvedUri2 = baseUri.resolve(uri2);
            URI resolvedUri3 = baseUri.resolve(uri3);

            URL url1 = resolvedUri1.toURL();
            System.out.println("URL 1 = " + url1);
            URL url2 = resolvedUri2.toURL();
            System.out.println("URL 2 = " + url2);
            URL url3 = resolvedUri3.toURL();
            System.out.println("URL 3 = " + url3);

            URI relativeURI = baseUri.relativize(resolvedUri2);
            System.out.println("Relative URI = " + relativeURI);


//            URI uri = new URI("hello");
            /*
            System.out.println("Scheme = " + resolvedUri.getScheme());
            System.out.println("Scheme-specific part = " + resolvedUri.getSchemeSpecificPart());
            System.out.println("Authority = " + resolvedUri.getAuthority());
            System.out.println("User info = " + resolvedUri.getUserInfo());
            System.out.println("Host = " + resolvedUri.getHost());
            System.out.println("Port = " + resolvedUri.getPort());
            System.out.println("Path = " + resolvedUri.getPath());
            System.out.println("Query = " + resolvedUri.getQuery());
            System.out.println("Fragment = " + resolvedUri.getFragment());
             */

        } catch (URISyntaxException ex) {
            System.out.println("URI Bad Syntax: " + ex.getMessage());
        } catch (MalformedURLException ex) {
            System.out.println("URL Malformed: " + ex.getMessage());
        }

    }
}
