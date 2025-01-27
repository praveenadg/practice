package problems.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Deadlock {

    public static void main(String args[]) {
        final String resource1 = "ratan jaiswal";
        final String resource2 = "vimal jaiswal";
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> "test");
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (resource1) {
                    System.out.println("resource1 locked by" + Thread.currentThread().getName());
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }

                synchronized (resource2) {
                    System.out.println("resource2 locked by" + Thread.currentThread().getName());
                }

            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (resource2) {
                    System.out.println("resource2 locked by" + Thread.currentThread().getName());
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                synchronized (resource1) {
                    System.out.println("resource1 locked by" + Thread.currentThread().getName());
                }
            }
        };
        t1.start();
        t2.start();

    }


}
