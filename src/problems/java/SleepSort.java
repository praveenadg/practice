package problems.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SleepSort {
    List<Integer> list = new ArrayList<>();

    void sleepSort(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        list.add(i);
    }

    public static void main(String args[]) {
        // ThreadPractice threadPractice = new ThreadPractice();
        SleepSort sleepSort = new SleepSort();
        int[] arr = new int[]{5, 4, 3, 2, 1};
        List<Integer> list = new ArrayList<>();
//        for (int i = 99; i > 49; i--) {
//            list.add(i);
//        }
//        for (int i = 0; i < 49; i++) {
//            list.add(i);
//        }

        List<CompletableFuture<Void>> futureList1 = new ArrayList<>();
        for (int i : arr) {
            futureList1.add(CompletableFuture.runAsync(() -> sleepSort.sleepSort(i)));
        }
        futureList1.forEach(CompletableFuture::join);
        System.out.println(sleepSort.list);
    }
}
