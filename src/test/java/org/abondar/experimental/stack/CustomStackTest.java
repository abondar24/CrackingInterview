package org.abondar.experimental.stack;

import org.abondar.experimental.structs.stack.CustomStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CustomStackTest {


    @Test
    public void customStackTest() {
        CustomStack<Integer> cs = new CustomStack<>();

        assertTrue(cs.isEmpty());
        cs.push(1);
        cs.push(2);
        cs.push(3);

        assertEquals((Object) 3, cs.peek());

        cs.pop();
        assertEquals((Object) 2, cs.peek());
    }


}
