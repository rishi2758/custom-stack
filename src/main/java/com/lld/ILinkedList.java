package com.lld;

public interface ILinkedList<T> {
    
    T addFirst(T data);

    T addLast(T data);

    boolean isEmpty();

    T removeFirst();

    T removeLast();

    T getFirst();

    T getLast();
}
