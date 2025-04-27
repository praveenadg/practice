package problems.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CounterUsingSemaphore {
    private final Semaphore semaphore;
    // private Mutex
    int count = 0;

    public CounterUsingSemaphore() {
        semaphore = new Semaphore(1);
    }

    public void increment() throws InterruptedException {
        semaphore.acquire();//without semaphore multiple threads will increment at the same time and we will loose the increments
        count++;
        // Thread.sleep(10);
        semaphore.release();
    }

    private int getCount() {
        return count;
    }

    public static void main(String args[]) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CounterUsingSemaphore counterUsingSemaphore = new CounterUsingSemaphore();
        for (int i = 0; i < 10000; i++) {
            executorService.submit(() -> {
                try {
                    counterUsingSemaphore.increment();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
        executorService.shutdown();
        // Thread.sleep(5);
        System.out.println(counterUsingSemaphore.getCount());
    }
}
