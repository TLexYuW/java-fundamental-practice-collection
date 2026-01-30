package com.lex.practice.sealed.marker_interface;

import java.util.List;

/**
 * @author : Lex Yu
 */
public class Z<T extends HasCommonBase> {
    private String SamePropertyX;
    private String SamePropertyY;
    List<T> someEntityLsit;
}
