package com.skystmm.common;

/**
 * Created by Administrator on 2018/1/22.
 */

public class LinkedList<T> {
    private T value;
    public  LinkedList next;

    public LinkedList(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
