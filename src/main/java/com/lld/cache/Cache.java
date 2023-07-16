package com.lld.cache;

public interface Cache<K extends CacheKey, V> {

    void put(K key, V value);
    
    void setTtl(long ttlInMillis);

    V get(K key);

}
