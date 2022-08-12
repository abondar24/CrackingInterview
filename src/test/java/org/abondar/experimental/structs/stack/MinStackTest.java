package org.abondar.experimental.structs.stack;

import org.abondar.experimental.structs.stack.CustomStack;
import org.abondar.experimental.structs.stack.MinStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinStackTest {

    @Test
    public void stackMinTest() {
        MinStack stack = new MinStack();


        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals((Object) 1, stack.min());

    }


    @Test
    public void sortStackTest() {
        MinStack stack = new MinStack();

        stack.push(1);
        stack.push(12);
        stack.push(8);
        stack.push(3);

        stack.sort();
        CustomStack<Integer> sorted = stack.getStack();
        assertEquals((Object) 12, sorted.peek());
    }


    @Test
    public void sortStackTest1() {
        MinStack stack = new MinStack();

        stack.push(5);
        stack.push(10);
        stack.push(7);
        stack.push(14);


        stack.sort();
        CustomStack<Integer> sorted = stack.getStack();
        assertEquals((Object) 14, sorted.peek());
    }



}
