package com.lex.example_6;

import java.util.*;

/**
 * @author : LEX_YU
 * @date : 2023/4/8
 * @last_modified_date : 2023/4/8
 */
public class BoundedGenerics {
    public static void main(String[] args) {
        // error
        // Type parameter 'java.lang.String' is not within its bound; should implement 'java.util.Collection'
        // new CollectionGeneric<String>();

        new CollectionGeneric<>(new ArrayDeque<>()).show();
        new CollectionGeneric<>(new ArrayList<>()).show();
        new CollectionGeneric<>(new LinkedHashSet<>()).show();
        new CollectionGeneric<>(new LinkedList<>()).show();
        new CollectionGeneric<>(new Stack<>()).show();
        new CollectionGeneric<>(new TreeSet<>()).show();
        new CollectionGeneric<>(new Vector<>()).show();
    }
}

class CollectionGeneric <T extends Collection> {
    private final T collection;

    CollectionGeneric(T collection){
        this.collection = collection;
    }

    void show(){
        System.out.println(this.collection.getClass().getName());
    }
}
