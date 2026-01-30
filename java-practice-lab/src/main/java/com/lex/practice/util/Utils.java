package com.lex.practice.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author : Lex Yu
 */
public class Utils {

    private Utils() {}

    public static String formatter(long currentTimeMillis) {
        Instant instant = Instant.ofEpochMilli(currentTimeMillis);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
        return formatter.format(instant);
    }
}
