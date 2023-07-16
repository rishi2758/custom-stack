package com.lld.stack;

import com.lld.linkedlist.CustomLinkedList;
import com.lld.linkedlist.ILinkedList;

public class StackLinkedList<T> implements Stack<T> {

    private final ILinkedList<T> list;

    public StackLinkedList() {
        this.list = new CustomLinkedList<>();
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
