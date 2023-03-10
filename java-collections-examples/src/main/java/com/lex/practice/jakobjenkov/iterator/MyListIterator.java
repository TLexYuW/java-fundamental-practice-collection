package com.lex.practice.jakobjenkov.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/9
 */
public class MyListIterator<T> implements Iterator<T>{

    private List<T> source = null;
    private int index = 0;

    public MyListIterator(List<T> source) {
        this.source = source;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.source.size();
    }

    @Override
    public T next() {
        return this.source.get(this.index++);
    }
}
