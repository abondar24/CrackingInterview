package org.abondar.experimental.stack;

import org.abondar.experimental.structs.stack.CustomStack;
import org.abondar.experimental.structs.stack.StackSet;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackSetTest {

    @Test
    public void setOfStacksTest() {
        StackSet ss = new StackSet(3);

        ss.push(1);
        assertEquals((Object) 1, ss.peek());

        ss.push(2);
        ss.push(3);
        ss.push(4);
        ss.push(5);
        assertEquals((Object) 5, ss.peek());

        Map<CustomStack, Integer> stackSet = ss.getStackSet();


        assertEquals(2, stackSet.size());
        assertEquals((Object) 5, ss.pop());

    }


    @Test
    public void setOfStacksTestThreeStacks() {
        StackSet ss = new StackSet(3);

        ss.push(1);
        ss.push(2);
        ss.push(3);
        ss.push(4);
        ss.push(5);
        ss.push(6);
        ss.push(7);

        Map<CustomStack, Integer> stackSet = ss.getStackSet();

        assertEquals(3, stackSet.size());

    }

}
