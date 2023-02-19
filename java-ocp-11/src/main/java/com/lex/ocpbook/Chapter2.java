package com.lex.ocpbook;


import java.util.List;

/**
 * @author : LEX_YU
 * @date : 07/02/2023 10:32 pm
 */
public class Chapter2 {
    public static void main(String[] args) {
        // 1.
        /*
        var t1 = "t";
        double t2 = 3.14;
        int t3 = 3;
        String t4 = "e";
        char t5 = 'y';
        Object t6 = 'x';
        System.out.println(((Object)t5));
        System.out.println(((Object)t5).getClass());
        System.out.println(((Object)t5).getClass().getSimpleName());
//        switch (t2) {
//            case "Double":
//                System.out.println(t2);
//                break;
//            case "Integer":
//                System.out.println(t3);
//                break;
//            case "String":
//                System.out.println(t1 + " / " + t4);
//                break;
//            case "Character":
//                System.out.println(t5);
//                break;
//            case "Object":
//                System.out.println(t6);
//                break;
//            default:
//                System.out.println("None");
//                break;
//        }
         */
        // 2.
        /*
        var gas = true;
        do (System.out.println("helium"); gas = gas ^ gas;
        gas = !gas;)while (!gas) ;
        do {
            System.out.println("helium");
            gas = gas ^ gas;
            gas = !gas;
        } while (!gas);
         */
        // 3.
        /*
        int m = 0, n = 0;
        while (m < 5) {
            n++;
            if (m == 3)
                continue;
            switch (m) {
                case 0:
                case 1:
                    n++;
                default:
                    n++;
            }
            m++;
        }
        System.out.println(m + " " + n);
         */
        // 4.
        /*
        var quest1 = new int[] {3} ;
        var quest2 = List.of(3)  ;
        var quest3 = new String[3]  ;
        for(var zelda : quest1) {
            System.out.println("new int[] {3} : " + zelda);
        }
        for(var zelda : quest2) {
            System.out.println(zelda);
        }
        for(var zelda : quest3) {
            System.out.println(zelda);
        }
         */
        // 5.
        /*
        int x = 1;
        switch (x){
            default:
                System.out.println("DEFAULT");
                break;
        }
         */
        // 7.
        /*
        for (int i = 0; i < 10; i++) {

        }
        for ( : ) {
        }
        */
        // 8.
        /*
        var plan = 1;
        plan = plan++ + --plan;
        if (plan == 1) {
            System.out.print("Plan A");
        } else {
            if (plan == 2) System.out.print("Plan B");
        } else System.out.print("Plan C");
         */
        // 9.
        /*
        var race = "";
        loop:
        do {
            race += "x";
            break loop;
        } while (true);
        System.out.println(race);
         */
        // 10.
        /*
        int[] circus = {1,2,3,4,5};
        for (int i=circus.length-1; i>=0; i--)
            System.out.print(circus[i]);
         */
        // 11.
        /*
        var bottles = List.of("glass", "plastic", "can");
        for (int type = 1; type < bottles.size();) {
            System.out.print(bottles.get(type) + "-");
            if(type < bottles.size()) break;
        }
        System.out.print("end");
         */
        // 12.
        /*
        final var GOOD = 100;
        var score = 10;
        switch (score) {
            default:
                1 :System.out.print("1-");
                -1 :System.out.print("2-");
                break;
                4, 5 :System.out.print("3-");
                6 :System.out.print("4-");
                9 :System.out.print("5-");
        }
         */
        /*
        final var GOOD = 100;
        var score = 10;
        switch (score) {
            default:
            case 1:
                System.out.print("1-");
            case -1:
                System.out.print("2-");
                break;
            case 4, 5:
                System.out.print("3-");
            case 6:
                System.out.print("4-");
            case 9:
                System.out.print("5-");
        }
         */
        // 13.
        /*
        int pterodactyl = 8;
        long triceratops = 3;
        if(pterodactyl % 3 > 1 + 1)
            triceratops++;
        triceratops--;
        System.out.print(triceratops);
         */
        // 14.
        /*
        int colorOfRainbow = 10;
        ____ red = 5;
        switch (colorOfRainbow) {
            default:
                System.out.print("Home");
                break;
            case red:
                System.out.print("Away");
        }
         */
        // 16.

    }

    // 6.
    /*
    void dance() {
        var singer = 0;
        while (singer)
            System.out.print(singer++);
    }
     */
    // 15.
    /*
    public void magic() {
        do {
            int trick = 0;
            LOOP:
            do {
                trick++;
            } while (trick < 2--);
            continue LOOP;
        } while (1 > 2);
        System.out.println(trick);
    }
     */
}
