package com.lex.example_3;

/**
 * @author : LEX_YU
 * @date : 2023/4/8
 * @last_modified_date : 2023/4/8
 */
public class UseGenerics {
    public static void main(String[] args) {
        ObjectPoint integerPoint = new ObjectPoint();
        integerPoint.setX(new Integer(100));
        Integer integerX = (Integer)integerPoint.getX();
        System.out.println(integerX);

        ObjectPoint floatPoint = new ObjectPoint();
        floatPoint.setX(new Float(100.12f));
        Float floatX = (Float)floatPoint.getX();
        System.out.println(floatX);

        ObjectPoint floatPoint2 = new ObjectPoint();
        floatPoint.setX(new Float(100.12f));
        String floatX2 = (String)floatPoint.getX();
        System.out.println(floatX2);
    }

}
// 設置 Integer 型態的點座標
class IntegerPoint{
    private Integer x ;       // 表示 X 座標
    private Integer y ;       // 表示 Y 座標
    public void setX(Integer x){
        this.x = x ;
    }
    public void setY(Integer y){
        this.y = y ;
    }
    public Integer getX(){
        return this.x ;
    }
    public Integer getY(){
        return this.y ;
    }
}

// 設置 Float 型態的點座標
class FloatPoint{
    private Float x ;       // 表示 X 座標
    private Float y ;       // 表示 Y 座標
    public void setX(Float x){
        this.x = x ;
    }
    public void setY(Float y){
        this.y = y ;
    }
    public Float getX(){
        return this.x ;
    }
    public Float getY(){
        return this.y ;
    }
}
class ObjectPoint {
    private Object x ;
    private Object y ;
    public void setX(Object x){
        this.x = x ;
    }
    public void setY(Object y){
        this.y = y ;
    }
    public Object getX(){
        return this.x ;
    }
    public Object getY(){
        return this.y ;
    }
}

