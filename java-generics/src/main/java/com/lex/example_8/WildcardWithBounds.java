package com.lex.example_8;

/**
 * @author : LEX_YU
 * @date : 2023/4/8
 * @last_modified_date : 2023/4/8
 */
public class WildcardWithBounds {
    public static void main(String[] args) {
        // Apple is a Fruit
        // Apple in Plate is not a Fruit in Plate
        // Plate<Fruit> plate = new Plate<Apple>(new Apple());

        // Producer, 只讀取，不能存
        Plate<? extends Fruit> plateProducer = new Plate<Apple>(new Apple());
//        plate(new Fruit());
//        plate(new Apple());
        Fruit fruit1 = plateProducer.get();
        Food food = plateProducer.get();
        Object o = plateProducer.get();
        System.out.printf("%s, %s, %s\n", fruit1, food, o);
        // 只能讀取存放為Fruiit或其父類別
        // Apple apple = plateProducer.get();

        // Consumer, 能存，但往外讀取只能用Object
        Plate<? super Fruit> plateConsumer = new Plate<Food>(new Food());
        plateConsumer.set(new Fruit());
        plateConsumer.set(new Apple());

        // error, 無法存入 Fruit父類別
        // plateConsumer.set(new Food());

        // 讀取出來的東西只能存於Object類別內
//        Fruit fruit2 = plateConsumer.get();
//        Food food2 = plateConsumer.get();
//        Apple apple = plateConsumer.get();
        Object o2 = plateConsumer.get();
        System.out.println(o2);

    }
}

//Lev 1
class Food {
}

//Lev 2
class Fruit extends Food {
}

class Meat extends Food {
}

//Lev 3
class Apple extends Fruit {
}

class Banana extends Fruit {
}

class Pork extends Meat {
}

class Beef extends Meat {
}

//Lev 4
class RedApple extends Apple {
}

class GreenApple extends Apple {
}

// Generic
class Plate<T> {
    private T item;

    public Plate(T t) {
        item = t;
    }

    public void set(T t) {
        item = t;
    }

    public T get() {
        return item;
    }
}
