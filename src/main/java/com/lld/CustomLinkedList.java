package com.lld;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements ILinkedList<T>, Iterable<T> {

    private Node<T> head;
    private Node<T> tail;

    @Override
    public void addFirst(T data) {
        Node<T> node = new Node<>(data);
        if(head == null) {
            node.backRef = head;
            tail = node;
        } else {
            Node<T> tmp = head;
            tmp.frontRef = node;
            node.backRef = tmp;
        }
        head = node;
    }

    @Override
    public void addLast(T data) {
        Node<T> node = new Node<>(data);
        if(tail == null) {
            node.frontRef = tail;
            head = node;
        } else {
            Node<T> tmp = tail;
            node.frontRef = tmp;
            tmp.backRef = node;
        }
        tail = node;
    }

    @Override
    public boolean isEmpty() {
        return head.backRef == tail.frontRef;
    }

    @Override
    public T removeFirst() {
        if(isEmpty()) {
            throw new IllegalCallerException("linked-list is empty");
        }

        Node<T> removed = head;
        removed.backRef.frontRef = null;
        head = removed.backRef;
        return removed.data;
    }

    @Override
    public T removeLast() {
        if(isEmpty()) {
            throw new IllegalCallerException("linked-list is empty");
        }

        Node<T> removed = tail;
        removed.frontRef.backRef = null;
        tail = removed.frontRef;
        return removed.data;
    }

    @Override
    public T getFirst() {
        if(isEmpty()) {
            throw new IllegalCallerException("linked-list is empty");
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if(isEmpty()) {
            throw new IllegalCallerException("linked-list is empty");
        }
        return tail.data;
    }

    private static class Node<T> {
        
        private T data;
        private Node<T> backRef;
        private Node<T> frontRef;

        public Node(T data) {
            this.data = data;
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new CustomLinkedListIterator();
    }

    public class CustomLinkedListIterator implements Iterator<T> {

        private Node<T> node;

        public CustomLinkedListIterator() {
            this.node = new Node<>(null);
            this.node = tail;
        }

        @Override
        public boolean hasNext() {
            return node != null;            
        }

        @Override
        public T next() {
            if(node != null) {
                Node<T> tmp = node;
                node = tmp.frontRef;
                return tmp.data;
            }  
            throw new NoSuchElementException("empty collection");
        }

    }
 
}
