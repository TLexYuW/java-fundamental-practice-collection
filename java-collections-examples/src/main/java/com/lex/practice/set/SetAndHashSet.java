package com.lex.practice.set;

import java.util.*;

/**
 * @author : Lex Yu
 * @date : 2023/6/24
 */
public class SetAndHashSet {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("W");
        names.add("L");
        names.add("K");
        names.add("S");
        System.out.println(names);
        System.out.println("----------------------------------------------------------------------------------------");

        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("----------------------------------------------------------------------------------------");

        names.forEach(System.out::println);
        System.out.println("----------------------------------------------------------------------------------------");

        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("----------------------------------------------------------------------------------------");

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 1, 2, 3);
        Set<Integer> numsSet = new HashSet<>(integerList);
//        Set<Integer> numsSet = new HashSet<>();
//        numsSet.addAll(integerList);
        System.out.println(numsSet);
        System.out.println("----------------------------------------------------------------------------------------");

        List<Integer> integerList1 = Arrays.asList(7,6,5,10,4,2,3,1);
        Set<Integer> integerTreeSet = new TreeSet<>(integerList1);
        System.out.println(integerTreeSet);
        System.out.println("----------------------------------------------------------------------------------------");

        List<Integer> integerList2 = Arrays.asList(100,7,6,5,10,4,2,3,1);
        Set<Integer> integerTreeSet1 = new LinkedHashSet<>(integerList2);
        System.out.println(integerTreeSet1);
        System.out.println("----------------------------------------------------------------------------------------");

        names.remove("L");
        System.out.println(names);
        System.out.println("----------------------------------------------------------------------------------------");

        System.out.println(names.size());
        System.out.println("----------------------------------------------------------------------------------------");

        System.out.println(names.contains("W"));
        System.out.println("----------------------------------------------------------------------------------------");

        names.clear();
        System.out.println(names);
        System.out.println("----------------------------------------------------------------------------------------");
    }
}
