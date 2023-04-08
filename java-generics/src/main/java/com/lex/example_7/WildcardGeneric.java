package com.lex.example_7;

/**
 * @author : LEX_YU
 * @date : 2023/4/8
 * @last_modified_date : 2023/4/8
 */
public class WildcardGeneric {
    public static void main(String[] args) {
        Point<?, ?> p = new Point(12, 13.5); // 自動封裝
        System.out.println("x : " + p.getX().getClass().getName());
        System.out.println("y : " + p.getY().getClass().getName());
        System.out.println("------------------------------------------");

        p = new Point(new Object(), new int[]{2,3});
        System.out.println("x : " + p.getX().getClass().getName());
        System.out.println("y : " + p.getY().getClass().getName());
        System.out.println("------------------------------------------");
    }
}
class Point<T, U> {
    private T x;
    private U y;

    Point(T x, U y){
        setPoint(x, y);
    }

    //作為參數傳入
    void setPoint(T x, U y){
        this.x = x;
        this.y = y;
    }

    //作為返回值
    T getX(){
        return this.x;
    }
    U getY(){
        return this.y;
    }
}
