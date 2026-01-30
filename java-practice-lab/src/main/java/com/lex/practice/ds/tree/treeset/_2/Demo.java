package com.lex.practice.ds.tree.treeset._2;

import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        // creating a TreeSet
        TreeSet<Integer> treeadd = new TreeSet<>();
        TreeSet<Integer> treesubset = new TreeSet<>();

        // adding in the tree set
        treeadd.add(1);
        treeadd.add(2);
        treeadd.add(3);
        treeadd.add(4);
        treeadd.add(5);
        treeadd.add(6);
        treeadd.add(7);
        treeadd.add(8);

        // creating subset
        treesubset = (TreeSet<Integer>) treeadd.subSet(3,false, 7,true);

        System.out.println("Tree subset data: " + treesubset);
    }
}
