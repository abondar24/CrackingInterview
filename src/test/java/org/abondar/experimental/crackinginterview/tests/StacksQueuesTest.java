package org.abondar.experimental.crackinginterview.tests;

import org.abondar.experimental.crackinginterview.StacksQueues.CustomStack;
import org.abondar.experimental.crackinginterview.StacksQueues.MultiStack;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class StacksQueuesTest {


    @Test
    public void customStackTest(){
        CustomStack<Integer> cs = new CustomStack<>();

        assertTrue(cs.isEmpty());
        cs.push(1);
        cs.push(2);
        cs.push(3);

        assertEquals((Object) 3,cs.peek());

        cs.pop();
        assertEquals((Object) 2,cs.peek());
    }

    @Test
    public void multiStackTest(){
        int [] arr = new int[]{2,10,12,3,5,6,90,24,33,1,0,15};
        MultiStack ms = new MultiStack(arr,3);

        List<CustomStack> stackList = ms.splitToStacks();
        assertEquals(3,stackList.size());
        assertEquals(3,stackList.get(0).peek());
        assertEquals(24,stackList.get(1).peek());
        assertEquals(15,stackList.get(2).peek());
    }


    @Test
    public void multiStackTestStackSizesDiffer(){
        int [] arr = new int[]{2,10,12,3,5};
        MultiStack ms = new MultiStack(arr,2);

        List<CustomStack> stackList = ms.splitToStacks();
        assertEquals(2,stackList.size());
        assertEquals(10,stackList.get(0).peek());
        assertEquals(5,stackList.get(1).peek());
    }
}
