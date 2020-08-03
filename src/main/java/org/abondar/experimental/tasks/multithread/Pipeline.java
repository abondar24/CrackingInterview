package org.abondar.experimental.tasks.multithread;

import java.util.concurrent.SynchronousQueue;

/**
 * A container which serves as a pipeline for a single element. The pipeline makes sure that no elements get lost,
 * i.e. you can only put a new element into the pipeline when the previous element has first been retrieved from it.
 */
public class Pipeline {


    private final SynchronousQueue<Object> queue = new SynchronousQueue<>();


    /**
     * Puts an element into the pipeline. If there is already an element in the pipeline, this method blocks and waits
     * until that element has been removed and the new element could be put into the pipeline.
     *
     * @param obj the element to put into the pipeline.
     */
    public void put(Object obj) {
        try {
            Thread.onSpinWait();
            queue.put(obj);
        } catch (InterruptedException ex){
            System.out.println(ex.getLocalizedMessage());
        }

    }

    /**
     * Removes and returns the current element from the pipeline. If there is no element in the pipeline, this method
     * blocks and waits until there is an element.
     *
     * @return the element that has been in the pipeline and that has now been removed from it.
     */
    public Object get() {
        try {
            Thread.onSpinWait();
            return queue.take();
        } catch (InterruptedException ex){
            System.out.println(ex.getLocalizedMessage());
        }
        return null;
    }

    /**
     * Entity that puts elements into a pipeline.
     */
    private static class Producer extends Thread {

        private final Pipeline pipeline;

        public Producer(Pipeline pipeline) {
            this.pipeline = pipeline;
        }

        @Override
        public void run(){
            while (true) {
                Object obj = new Object();
                System.out.println(currentThread() + " tries to put an element into the pipeline: " + obj);
                pipeline.put(obj);
                System.out.println(currentThread() + " has put an element into the pipeline: " + obj);
                try {
                    sleep((long) (Math.random() * 2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * Entity that retrieves elements from a pipeline.
     */
    private static class Consumer extends Thread {

        private final Pipeline pipeline;

        public Consumer(Pipeline pipeline) {
            this.pipeline = pipeline;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(currentThread() + " tries to get an element from the pipeline");
                Object obj = pipeline.get();
                System.out.println(currentThread() + " has retrieved an element from the pipeline: " + obj);
                try {
                    sleep((long) (Math.random() * 2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String... notUsed) {
        Pipeline pipeline = new Pipeline();
        for (int i = 1; i <= 3; i++) {
            new Producer(pipeline).start();
            new Consumer(pipeline).start();
        }
    }
}
