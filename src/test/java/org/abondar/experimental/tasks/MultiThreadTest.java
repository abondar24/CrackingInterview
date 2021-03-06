package org.abondar.experimental.tasks;

import org.abondar.experimental.tasks.multithread.InstantiationCounter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
