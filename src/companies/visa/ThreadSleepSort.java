package companies.visa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

// 1. Given an array of integers

// 2. For each integer, create a new thread that will do the following:

//     a. sleep itself for the value of the integer

//     b. after waking up, append the integer to a common output list

// 3. after all threads are finished, return the common output list

// Thread.sleep() static method which makes current thread to sleep
// thread.join() makes current thread wait until thread finishes executing

public class ThreadSleepSort {

    public static void main(String args[]) throws InterruptedException, ExecutionException, TimeoutException {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        usingThreadClass(arr);
        usingRunnable(arr);
        usingExecutor(arr);
        usingCompletable(arr);
    }


    private static void usingCompletable(int[] arr) {
        System.out.println("using usingCompletable");
        List<Integer> result = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (int i : arr) {
            Thread thread = new Thread(new RunnableThread(i, result));//
            threads.add(thread);
        }
        List<CompletableFuture<Void>> futures = threads.stream().map(thread -> CompletableFuture.runAsync(thread))
                .collect(Collectors.toList());

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println(result);
    }


    private static void usingExecutor(int[] arr) throws InterruptedException {
        System.out.println("using usingExecutor");
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Integer> result = new ArrayList<>();
        for (int i : arr) {
            Thread thread = new Thread(new RunnableThread(i, result));//
            executorService.submit(thread);
        }
        if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {//wait to terminate
            executorService.shutdownNow();
        }
        System.out.println(result);
    }

    //use this
    private static void usingRunnable(int[] arr) throws InterruptedException {
        System.out.println("using usingRunnable");
        List<Integer> result = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (int i : arr) {
            Thread thread = new Thread(new RunnableThread(i, result));//
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(result);
    }

    private static void usingThreadClass(int[] arr) throws InterruptedException {
        System.out.println("using ThreadClas");
        List<Integer> result = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (int i : arr) {
            Thread thread = new MyThread(i, result);//
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(result);
    }

    static class MyThread extends Thread {
        int i;
        List<Integer> list;

        MyThread(int i, List<Integer> list) {
            this.i = i;
            this.list = list;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.add(i);
        }
    }

    static class RunnableThread implements Runnable {
        int i;
        List<Integer> list;

        RunnableThread(int i, List<Integer> list) {
            this.i = i;
            this.list = list;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.add(i);
        }
    }
}
