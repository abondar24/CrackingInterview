package org.abondar.experimental.problems.multithread;

public class InstantiationCounter {
    private static int counter;

    public InstantiationCounter() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public synchronized int getNumOfInstances() {
        return counter;
    }

}
