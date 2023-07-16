package com.lld.cache;

import java.util.HashMap;
import java.util.Map;

import com.lld.linkedlist.CustomLinkedList;
import com.lld.linkedlist.ILinkedList;
import com.lld.linkedlist.CustomLinkedList.Node;

import lombok.Getter;
import lombok.Setter;

public class LRUCache<K extends CacheKey, V> implements Cache<K, V> {

    private Map<String, Pair<Node<String>, V>> currentCache;
    private ILinkedList<String> linkedList;
    private int cacheSize;
    private long ttl;

    public LRUCache(int size) {
        this.currentCache = new HashMap<>();
        this.cacheSize = size;
        this.linkedList = new CustomLinkedList<>();
    }

    @Override
    public void put(K key, V value) {
        if(cacheSize <= currentCache.size()) {
            String removedKey = linkedList.removeLast();
            currentCache.remove(removedKey);
        }
        Pair<Node<String>, V> entry;
        if(currentCache.containsKey(key.getKey())) {
            entry = currentCache.get(key.getKey());
            remove(entry.getLeft());
            linkedList.addFirst(key.getKey());
            entry.setRight(value);
        }  else {
            linkedList.addFirst(key.getKey());
            entry = Pair.of(linkedList.getFirstNode(), value);
        }
        currentCache.put(key.getKey(), entry);
    }

    @Override
    public void setTtl(long ttlInMillis) {
       this.ttl = ttlInMillis;
    }

    @Override
    public V get(K key) {
        if(currentCache.containsKey(key.getKey())) {
            Pair<Node<String>,V> entry = currentCache.get(key.getKey());
            remove(entry.getLeft());
            linkedList.addFirst(key.getKey());
            currentCache.put(key.getKey(), entry);
            return entry.getRight();
        }
        return null;
    }

    @Getter
    private static class Pair<P1, P2> {

        @Setter
        private P1 left;
        @Setter
        private P2 right;

        private Pair(P1 left, P2 right) {
            this.left = left;
            this.right = right;
        }

        public static <P1,P2> Pair<P1, P2> of(P1 left, P2 right) {
            return new Pair<>(left, right);
        }
    }

    private void remove(Node<String> key) {
        if(key.getBackRef() != null) {
            Node<String> prev = key.getBackRef();
            prev.setFrontRef(key.getFrontRef());
        }else if(key.getFrontRef() != null) {
            Node<String> next = key.getFrontRef();
            next.setBackRef(key.getBackRef());
        }else {
            linkedList.removeFirst();
        }
    }
}
