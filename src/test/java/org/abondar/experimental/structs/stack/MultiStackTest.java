package org.abondar.experimental.structs.stack;

import org.abondar.experimental.structs.stack.CustomStack;
import org.abondar.experimental.structs.stack.MultiStack;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiStackTest {

    @Test
    public void multiStackTest() {
        int[] arr = new int[]{2, 10, 12, 3, 5, 6, 90, 24, 33, 1, 0, 15};
        MultiStack ms = new MultiStack(arr, 3);

        List<CustomStack> stackList = ms.splitToStacks();
        assertEquals(3, stackList.size());
        assertEquals(3, stackList.get(0).peek());
        assertEquals(24, stackList.get(1).peek());
        assertEquals(15, stackList.get(2).peek());
    }

    @Test
    public void multiStackTestStackSizesDiffer() {
        int[] arr = new int[]{2, 10, 12, 3, 5};
        MultiStack ms = new MultiStack(arr, 2);

        List<CustomStack> stackList = ms.splitToStacks();
        assertEquals(2, stackList.size());
        assertEquals(10, stackList.get(0).peek());
        assertEquals(5, stackList.get(1).peek());
    }

}
