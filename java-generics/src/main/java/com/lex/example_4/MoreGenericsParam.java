package com.lex.example_4;

/**
 * @author : LEX_YU
 * @date : 2023/4/8
 * @last_modified_date : 2023/4/8
 */
public class MoreGenericsParam {
    public static void main(String[] args) {
        MorePoint<Integer, String> morePoint = new MorePoint<>();
        morePoint.setX(new Integer(1));
        morePoint.setName("Second Param Name");
        System.out.println(morePoint.getX() + ", " + morePoint.getName());
    }
}

//定義
class MorePoint<T, U> { //多泛型參數型態 T, U
    private T x;
    private U name;

    //作為參數傳入
    public void setX(T x){
        this.x = x;
    }
    public void setName(U name){
        this.name = name;
    }

    //作為返回值
    public T getX(){
        return this.x;
    }
    public U getName(){
        return this.name;
    }
}