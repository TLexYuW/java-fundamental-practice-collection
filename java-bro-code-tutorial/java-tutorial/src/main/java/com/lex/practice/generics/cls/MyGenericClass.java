package com.lex.practice.generics.cls;

/**
 * @author : LEX_YU
 * @date : 2023/4/8
 * @last_modified_date : 2023-2023/4/8
 */
public class MyGenericClass<T extends Number, T2 extends Number> {
    T x;
    T2 y;

    public MyGenericClass(T x, T2 y) {
        this.x = x;
        this.y = y;
    }

    public T getValueT() {
        return x;
    }
    public T2 getValueT2() {
        return y;
    }
}
