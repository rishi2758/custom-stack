package com.lld.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomStackTests {
    
    @Test
    public void testBasicStackOps() {
        Stack<Integer> stack = new StackLinkedList<>();
        for(int i = 0; i <= 5; i++) {
            stack.push(i);
        }
        int i = 5;
        while(!stack.isEmpty()) {
            if(i < 0) {
                break;
            }
            assertEquals(5, stack.peek().intValue());
            i--;
        }
        assertFalse(stack.isEmpty());
        i = 5;
        while(!stack.isEmpty()) {
            assertEquals(i, stack.pop().intValue());
            i--;
        }
        assertTrue(stack.isEmpty());
    }

}
