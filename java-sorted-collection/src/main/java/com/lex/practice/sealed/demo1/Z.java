package com.lex.practice.sealed.demo1;

import java.util.List;

/**
 * @author : Lex Yu
 */
public class Z<T extends CommonEntity> {
    private String SamePropertyX;
    private String SamePropertyY;
    List<T> someEntityLsit;
}
