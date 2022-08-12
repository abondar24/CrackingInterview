package org.abondar.experimental.structs.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoStackQueueTest {

    @Test
    public void twoStackQueueTest() {
        TwoStackQueue<Integer> tsq = new TwoStackQueue<>();

        tsq.add(1);
        assertEquals((Object) 1, tsq.peek());

        tsq.add(2);
        tsq.add(3);
        assertEquals((Object) 1, tsq.remove());

        tsq.add(4);
        tsq.add(5);
        assertEquals((Object) 2, tsq.peek());
    }


}
