package com.lex.ocpbook;


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
    }
// 6.
    /*
    void dance() {
        var singer = 0;
        while (singer)
            System.out.print(singer++);
    }
     */
}
