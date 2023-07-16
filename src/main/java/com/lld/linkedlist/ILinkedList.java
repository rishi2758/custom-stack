package com.lld.linkedlist;

import com.lld.linkedlist.CustomLinkedList.Node;

public interface ILinkedList<T> {
    
    void addFirst(T data);

    void addLast(T data);

    boolean isEmpty();

    T removeFirst();

    T removeLast();

    T getFirst();

    T getLast();

    Node<T> getFirstNode();

    Node<T> getLastNode();
}
