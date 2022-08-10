package org.abondar.experimental.problems.multithread;

import org.abondar.experimental.problems.multithread.InstantiationCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiThreadTest {

    @Test
    public void instanceCountTest() throws Exception{
        InstantiationCounter counter = new InstantiationCounter();
        new InstantiationCounter();

        DemoThread demoThread = new DemoThread();
        demoThread.run();
        demoThread.run();

        assertEquals(4,counter.getNumOfInstances());
    }


    private static class DemoThread extends Thread {
        @Override
        public void run() {
            new InstantiationCounter();
        }
    }
}
