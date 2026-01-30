package com.lex.practice.jsoup.clean;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

/**
 * @author : Lex Yu
 * Sanitize untrusted HTML
 */
public class CleaningHTML {
    /*
     You want to allow untrusted users to supply HTML for output on your website (e.g. as comment submission).
     You need to clean this HTML to avoid cross-site scripting (XSS) attacks.
     */
    public static void main(String[] args) {
        String unsafe =
                "<p><a href='http://example.com/' onclick='stealCookies()'>Link</a></p>";
        String safe = Jsoup.clean(unsafe, Safelist.basic());
        // now: <p><a href="http://example.com/" rel="nofollow">Link</a></p>
        System.out.println(safe);
    }

}
