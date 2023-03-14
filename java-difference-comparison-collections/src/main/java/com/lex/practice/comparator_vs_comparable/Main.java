package com.lex.practice.comparator_vs_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/10
 */
public class Main {
    public static void main(String[] args) {
        /*
        List<Integer> nums = new ArrayList<>();
        nums.add(43);
        nums.add(31);
        nums.add(72);
        nums.add(29);
        List<Integer> list = new ArrayList<>(nums);
         */
        /*
        Collections.sort(list);
        System.out.println(list); // [29, 31, 43, 72]
        System.out.println(nums); // [43, 31, 72, 29]
        list.sort(null);
        System.out.println(list); // [29, 31, 43, 72]
        System.out.println(nums); // [43, 31, 72, 29]
         */

        // Use your own logic
        /*
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                if (i % 10 > j % 10) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        */
        /*
        Comparator<Integer> comparator = (i, j) -> {
            if (i % 10 > j % 10) {
                return 1;
            } else {
                return -1;
            }
        };
        Collections.sort(list,comparator);
        System.out.println(list); // [31, 72, 43, 29]
        System.out.println(nums); // [43, 31, 72, 29]
        list.sort(comparator);
        System.out.println(list); // [31, 72, 43, 29]
        System.out.println(nums); // [43, 31, 72, 29]
         */

        Comparator<Student> comparator = (i, j) -> {
            /*
            if (i.age > j.age) {
                return 1;
            } else {
                return -1;
            }
             */
            return i.age > j.age ? 1 : -1;
        };
        List<Student> nums = new ArrayList<>();
        nums.add(new Student(21, "Nick"));
        nums.add(new Student(12, "John"));
        nums.add(new Student(18, "Peter"));
        nums.add(new Student(20, "K"));
        Collections.sort(nums);
        System.out.println(nums);
        for (Student s : nums) {
            System.out.println(s);
        }
    }
}
class Student implements Comparable<Student> {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student that) {
        if (this.age > that.age) {
            return 1;
        } else {
            return -1;
        }
    }
}