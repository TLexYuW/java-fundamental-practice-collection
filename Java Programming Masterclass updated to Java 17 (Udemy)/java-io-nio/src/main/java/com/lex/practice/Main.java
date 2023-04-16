package com.lex.practice;

import com.lex.practice.course_source.Location;

import java.io.FileWriter;

import com.lex.practice.course_source.Locations;

/**
 * @author : Lex Yu
 * @date : 2023/4/14
 * @last_modified : 2023/4/14
 */
public class Main {
    public static void main(String[] args) {
        try(FileWriter fw = new FileWriter("locations.txt")) {
            for (Location location : Locations.locations.values()) {
                fw.write(location.getLocationID() + ", " + location.getDescription());
            }
        } catch (Exception ex) {
            System.out.println("err");
        }
    }
}
