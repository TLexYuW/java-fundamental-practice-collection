package com.lex.ocpbook;

/**
 * @author : LEX_YU
 * @date : 05/02/2023 5:52 pm
 */
public class Chapter1 {
    public static void main(String[] args) {
        // 1.
        /*
        var _ = "test";
        var _blue = "test";
        var 2blue = "test";
        var blue$ = "test";
        var Blue = "test";
         */
        // 2.
        /*
        int meal = 5;
        int tip = 2;
        var total = meal + (meal>6 ? tip++ : tip--);
        System.out.println(total);
         */
        // 3.
        /*
        var q1 = 4.0f;
        float q2 = 4.0f;
        Float q3 = 4.0f;
        double q4 = 4.0f;
        Double q5 = 4.0f;
        Object q6 = 4.0f;
        */
        // 4.
        /*
        var b = "12";
        b += "3";
        b.reverse();
        System.out.println(b);
         */
        /*
        var b1 = "12";
        b1 += "3";
        StringBuilder sb = new StringBuilder(b1);
        sb.reverse();
        System.out.println(sb);
         */
        // 5.
        /*
        var line = new StringBuilder("-");
        var anotherLine = line.append("-");
        System.out.println(line.equals(anotherLine));
        System.out.print(line == anotherLine);
        System.out.print(" ");
        System.out.println(line.length());
        System.out.println(line + ", Hashcode" + line.hashCode());
        System.out.println(anotherLine + ", Hashcode" + anotherLine.hashCode());
        String l = line.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(line));
        String al = anotherLine.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(anotherLine));
        System.out.println(l);
        System.out.println(al);
        var t1 = new String("test");
        var t2 = new String("test");
        String t1sih = t1.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(t1));
        String t2sih = t2.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(t2));
        System.out.println(t1 + ", Hashcode" + t1.hashCode());
        System.out.println(t2 + ", Hashcode" + t2.hashCode());
        System.out.println(t1sih);
        System.out.println(t2sih);
         */
        // 7.
        /*
        var line = new String("-");
        var anotherLine = line.concat("-");
        System.out.println(line + ", Hashcode" + line.hashCode());
        System.out.println(anotherLine + ", Hashcode" + anotherLine.hashCode());
        String l = line.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(line));
        String al = anotherLine.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(anotherLine));
        System.out.println(l);
        System.out.println(al);
        System.out.print(line == anotherLine);
        System.out.print(" ");
        System.out.print(line.length());
         */
        // 8.
        /*
        byte pi1 = 3.14;
        double pi2 = 3.14;
        float pi3 = 3.14;
        short pi4 = 3.14;
        var pi5 = 3.14;
         */
        // 10.
        /*
        Comparator c1 = (j, k) -> 0;
        Comparator<String> c2 = (String j, String k) -> 0;
        Comparator c3 = (var j, String k) -> 0;
        Comparator c4 = (var j, k) -> 0;
        Comparator c5 = (var j, var k) -> 0;
         */
        // 12.
        /*
        var teams = new StringBuilder("333");
        teams.append(" 806");
        teams.append(" 1601");
        System.out.print(teams);
         */
        // 13.
        /*
        double num1, int num2 = 0;
        int num3, num4;
        int num5, num6 = 0;
        int num7 = 0, num8 = 0;
         */
        // 15.
        /*
        var list = new ArrayList<Integer>();
        list.add(10);
        list.add(9);
        list.add(8);
        var num = 9;
        list.removeIf(x -> {
            int keep = num;
            return x != keep;
        });
        System.out.println(list);
        list.removeIf(x -> {
            int keep = num;
            return x == keep;
        });
        System.out.println(list);
         */
        // 16.
        /*
        var happy = " :) - (: ";
        var really = happy.trim();
        System.out.println(really);
        var question = happy.substring(1, happy.length() - 1) ;
        System.out.println(question);
        System.out.println(really.equals(question))
         */
        // 17.
        /*
        double num1 = 2.718;
        double num2 = 2._718;
        double num3 = 2.7_1_8;
        double num4 = _2.718;
         */
        // 21.
        /*
        var sb = new StringBuilder("radical").insert(sb.length(), "robots");
        System.out.println(sb);
         */
        // 22.
        /*
        int time = 9;
        int day = 3;
        var dinner = ++time >= 10 ? day-- <= 2 ? "Takeout" : "Salad" : "Leftovers";
        System.out.println(dinner);
         */
        // 23.
        /*
        var teams = new String("694");
        teams.concat(" 1155");
        teams.concat(" 2265");
        teams.concat(" 2869");
        System.out.println(teams);
         */
        // 24.
        /*
        bool b = null;
        Bool bl = null;
        Boolean BL = null;
        int i = null;
        Integer in = null;
        String s = null;
         */
        // 25.
        /*
        int height = 2, length = 3;
        boolean w = height > 1 | --length < 4;
        var x = height!=2 ? length++ : height;
        boolean z = height % length == 0;
        System.out.println(w + "-" + x + "-" + z);
         */
        // 26.
        /*
        var sb = new StringBuilder();
        sb.append("red");
        sb.deleteCharAt(0);
        sb.delete(1, 2);
        System.out.println(sb);
         */
        // 27.
        /*
        String s = "xabcy";
        if (s.contains("abc")) System.out.println("1. " + true);
        if (s.equals("abc")) System.out.println("2. " + true);
         */
        // 28.
        /*
        boolean carrot = true;
        Boolean potato = false;
        var broccoli = true;
        carrot = carrot & potato;
        broccoli = broccoli ? !carrot : potato;
        potato = !broccoli ^ carrot;
        System.out.println(carrot + "," + potato + "," + broccoli);
         */
        // 29.
        /*
        var babies = Arrays.asList("chick", "cygnet", "duckling");
        babies.replaceAll(x -> { var newValue = "baby"; return newValue; });
        System.out.println(babies);
         */
        // 30.
        var builder = new StringBuilder("54321");
        builder.substring(2);
        String str = builder.substring(2);
        System.out.println(builder.charAt(1));
        System.out.println(str.charAt(1));


    }
    // 11.
    /*
    public static void secret1(String mystery) {
        char ch = mystery.charAt(3);
        mystery = mystery.insert(1, "more");
        int num = mystery.length();
    }
    public static void secret2(StringBuilder mystery) {
        char ch = mystery.charAt(3);
        mystery = mystery.insert(1, "more");
        int num = mystery.length();
    }
     */
}
// 14.
    /*
// line a1
var color1;
var color1v = "test";
class Magnet {
    // line a2
    var color2;
    var color2v = 0;
    public void attach() {
        // line a3
        var color3;
        var color3v = 0;
    }
    // line a4
    var color4;
}
     */

// 18.
class Airplane {
    static int start = 2;
    final int end;

    public Airplane(int x) {
        x = 4;
        end = x;
    }

    public void fly(int distance) {
        System.out.print(end - start + " ");
        System.out.print(distance);
    }

    public static void main(String... start) {
        new Airplane(10).fly(5);
    }
}

// 19.
class Countdown {
    public static void main(String[] args) {
        var builder = "54321";
        builder = builder.substring(4);
        System.out.println(builder.charAt(2));
    }
}

// 20.
class Rematerialize {
    public static void main(String[] input) {
        int init = 11;
        int split = 3;
        int partA = init / split;
        int partB = init % split;
        int result = split * (partB + partA);
        System.out.print(result);
    }
}
