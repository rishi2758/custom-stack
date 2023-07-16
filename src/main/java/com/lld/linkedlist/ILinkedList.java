package com.lld.linkedlist;

public interface ILinkedList<T> {
    
    void addFirst(T data);

    void addLast(T data);

    boolean isEmpty();

    T removeFirst();

    T removeLast();

    T getFirst();

    T getLast();
}
