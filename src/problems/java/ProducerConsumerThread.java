package problems.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumerThread {

    //use put and take from BlockingQueue
    public static void main(String args[]) {

        //A Queue that additionally supports operations that wait for the queue to become non-empty when retrieving an element, and wait for space to become available in the queue when storing an element.
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>();
        List<Integer> list = new ArrayList<>();
        Thread t1 = new Thread(new Producer(blockingQueue));
        Thread t2 = new Thread(new Consumer(blockingQueue));
        t1.start();
        t2.start();
    }

    public static class Producer implements Runnable {
        private final BlockingQueue<Integer> sharedQueue;

        Producer(BlockingQueue<Integer> sharedQueue) {
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    sharedQueue.put(i);
                    System.out.println("produced= " + i + " ThreadName= " + Thread.currentThread().getName());

                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static class Consumer implements Runnable {
        private final BlockingQueue<Integer> sharedQueue;

        Consumer(BlockingQueue<Integer> sharedQueue) {
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int j = sharedQueue.take();
                    System.out.println("consumed= " + j + " ThreadName= " + Thread.currentThread().getName());

                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
