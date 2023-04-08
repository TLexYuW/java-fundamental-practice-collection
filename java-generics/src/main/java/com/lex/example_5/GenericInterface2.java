package com.lex.example_5;

/**
 * @author : LEX_YU
 * @date : 2023/4/8
 * @last_modified_date : 2023/4/8
 */
public class GenericInterface2 {
    public static void main(String[] args) {
        InfoImpl i = new InfoImpl("This is Generic interface.");
        System.out.println(i.getVar());
    }
}
interface Info2<T> { //在接口上定義泛型
    T getVar(); //定義抽象方法，抽象方法的返回值就是泛型型態
    void setVar(T x);
}

class InfoImpl2 implements Info2<String> { //定義泛型介面的子類別
    private String var;

    public InfoImpl2(String var){
        this.setVar(var);
    }

    @Override
    public void setVar(String var){
        this.var = var;
    }
    @Override
    public String getVar(){
        return this.var;
    }
}

