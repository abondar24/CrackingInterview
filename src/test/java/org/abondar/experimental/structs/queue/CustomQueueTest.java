package org.abondar.experimental.structs.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomQueueTest {

    @Test
    public void customQueueTest() {
        CustomQueue<Integer> cq = new CustomQueue<>();
        assertTrue(cq.isEmpty());

        cq.add(1);
        cq.add(2);
        cq.add(3);
        assertEquals((Object) 1, cq.peek());
        assertEquals((Object) 1, cq.remove());
        assertEquals((Object) 2, cq.peek());


    }

}
