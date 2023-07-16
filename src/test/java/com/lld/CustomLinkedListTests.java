package com.lld;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.Iterator;

import org.junit.Test;

public class CustomLinkedListTests 
{
    @Test
    public void testLLforBasisOps()
    {
        CustomLinkedList<Integer> ll = new CustomLinkedList<>();
        for(int i = 0; i <= 5; i++) {
            ll.addFirst(i);
        }

        for(int i = -1; i >= -5; i--) {
            ll.addLast(i);
        }

        Iterator<Integer> itr = ll.iterator();
        Integer i = -5;
        while (itr.hasNext()) {
            assertEquals(itr.next(), i);
            i++;
        }
    }

    @Test
    public void testLLforBasisOps_ForAlternatingAdd()
    {
        CustomLinkedList<Integer> ll = new CustomLinkedList<>();
        for(int i = 1; i <= 5; i++) {
            ll.addFirst(i);
            ll.addLast(-i);
        }

        Iterator<Integer> itr = ll.iterator();
        int[] expected = {-5, -4, -3, -2, -1 , 1 , 2, 3 , 4, 5};
        int[] actual = new int[10];
        int i = 0;
        while (itr.hasNext()) {
            actual[i++] = itr.next();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testLLforBasicRemoveAndGetOps() {
        CustomLinkedList<Integer> ll = new CustomLinkedList<>();
        for(int i = 1; i <= 5; i++) {
            ll.addFirst(i);
            ll.addLast(-i);
        }

        assertEquals(5, ll.removeFirst().intValue());
        assertEquals(4, ll.getFirst().intValue());
        assertEquals(-5, ll.removeLast().intValue());
        assertEquals(-4, ll.getLast().intValue());
    }
    
    @Test
    public void attemptToRemoveElementFromEmptyListThrowsError() {
        CustomLinkedList<Integer> ll = new CustomLinkedList<>();
        for(int i = 1; i <= 5; i++) {
            ll.addFirst(i);
            ll.addLast(-i);
        }
        while(true) {
             try {
                ll.removeFirst();
            } catch (IllegalCallerException e) {
                assertSame(e.getMessage(), "linked-list is empty");
                break;
            }
        }
    }
}
