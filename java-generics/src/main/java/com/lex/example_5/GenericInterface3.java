package com.lex.example_5;

/**
 * @author : LEX_YU
 * @date : 2023/4/8
 * @last_modified_date : 2023/4/8
 */
public class GenericInterface3 {
    public static void main(String[] args) {
        InfoImpl3<String> i = new InfoImpl3<>("This is Generic interface.");
        System.out.println(i.getVar());
    }
}
interface Info3<T> { //在接口上定義泛型
    public T getVar(); //定義抽象方法，抽象方法的返回值就是泛型型態
    public void setVar(T x);
}

class InfoImpl3<T> implements Info3<T> { //定義泛型介面的子類別
    private T var; //定義屬性

    public InfoImpl3(T var){ //通過構造方法設置屬性內容
        this.setVar(var);
    }

    @Override
    public void setVar(T var){
        this.var = var;
    }
    @Override
    public T getVar(){
        return this.var;
    }
}

