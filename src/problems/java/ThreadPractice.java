package problems.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ThreadPractice {
    int x = 0;
    List<Integer> list = new ArrayList<>();

    void method() {
        for (int i = 0; i < 10000; i++) {
            x = x + 1;
        }
    }

    void sleepSort(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        list.add(i);
        // return i;
    }

    public static void main(String args[]) {
        ThreadPractice threadPractice = new ThreadPractice();
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            futureList.add(CompletableFuture.runAsync(() -> threadPractice.method()));
            CompletableFuture.supplyAsync(() -> 10);
        }

        int[] arr = new int[]{5, 4, 3, 2, 1};
        List<CompletableFuture<Void>> futureList1 = new ArrayList<>();
        for (int i : arr) {
            futureList1.add(CompletableFuture.runAsync(() -> threadPractice.sleepSort(i)));
        }
        futureList1.forEach(CompletableFuture::join);
        System.out.println(threadPractice.list);
    }
}
