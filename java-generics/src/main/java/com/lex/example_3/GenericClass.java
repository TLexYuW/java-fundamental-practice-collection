package com.lex.example_3;

/**
 * @author : LEX_YU
 * @date : 2023/4/8
 * @last_modified_date : 2023-2023/4/8
 */
public class GenericClass {
    public static void main(String[] args) {
        //IntegerPoint使用
        Point<Integer> p1 = new Point<Integer>();
        p1.setX(new Integer(100));
        System.out.println(p1.getX());

        //FloatPoint使用
        Point<Float> p2 = new Point<Float>();
        p2.setX(new Float(100.12f));
        System.out.println(p2.getX());
    }
}

//定義
class Point<T> {//此處可以隨便寫標識符號T
    private T x;

    //作為參數傳入
    public void setX(T x) {
        this.x = x;
    }

    //作為返回值
    public T getX() {
        return this.x;
    }
}