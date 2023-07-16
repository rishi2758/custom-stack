package com.lld.cache;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lombok.AllArgsConstructor;

public class LRUCacheTests {
    
    @Test
    public void testLRUCache() {
        Cache<CacheKey, String> lru = new LRUCache<>(5);
        lru.setTtl(5000);
        for(int i = 0 ; i < 4; i++) {
            lru.put(new CacheKeyImpl("key"+i), String.valueOf(i));
        }
        String value = lru.get(new CacheKeyImpl("key0"));
        assertEquals("0", value);
    }

    @AllArgsConstructor
    public class CacheKeyImpl implements CacheKey {
        private final String key;
        @Override
        public String getKey() {
            return this.key;
        }
    }
}
