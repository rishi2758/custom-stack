package com.lld;

import java.util.*;

public class StackLinkedList<T> implements Stack<T> {

    private final LinkedList<T> list;

    public StackLinkedList() {
        this.list = new LinkedList<>();
    }

    @Override
    public void push(T data) {
        list.addFirst(data);
    }

    @Override
    public T pop() {
        if(list.isEmpty()) {
            throw new IllegalAccessError("stack is empty");
        }
        return list.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public T peek() {
        return list.getFirst();
    }
    
}
