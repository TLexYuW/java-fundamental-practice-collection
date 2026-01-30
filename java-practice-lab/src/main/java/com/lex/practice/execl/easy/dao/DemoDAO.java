package com.lex.practice.execl.easy.dao;

import com.lex.practice.model.DemoData;

import java.util.List;

public class DemoDAO {

    public void save(List<DemoData> list) {
        for (DemoData demoData : list) {
            System.out.println("Saving " + demoData + " to DB");
        }
    }
}
