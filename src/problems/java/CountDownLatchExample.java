package problems.java;

import java.util.concurrent.CountDownLatch;

/**
 * 1. Create a countdown latch of size 3 -  marks as completed after 3 threads are executed
 * 2. Create thread in loop and pass the latch
 * 3. Each thread sleeps for random amount and then countdown the latch
 * 4. Once latch is reached zero there is no more waiting
 */
public class CountDownLatchExample {

    public static void main(String args[]) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < 10; i++) {
            MyThread thread = new MyThread(latch, (int) (Math.random() * 1000));
            thread.start();
        }

        latch.await();// waits for all thread to complete //Causes the current thread to wait until the latch has counted down to zero, unless the thread is interrupted.
        System.out.println("all threads completed");

    }

    public static class MyThread extends Thread {
        CountDownLatch latch;
        int delay;

        MyThread(CountDownLatch latch, int delay) {
            this.latch = latch;
            this.delay = delay;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(delay);
                System.out.println("running " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                latch.countDown();//Decrements the count of the latch, releasing all waiting threads if the count reaches zero.
            }
        }
    }
}
