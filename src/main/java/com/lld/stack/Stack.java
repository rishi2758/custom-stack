package com.lld.stack;

public interface Stack<T> {

    void push(T data);
    
    T pop();

    boolean isEmpty();

    T peek();
}
