package test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        System.out.println( 3+(0x1F));
        Singleton singleton = Singleton.getInstanceStatic();
        int[][] result = new int[][]{new int[]{1,3}, new int[]{2,4}};
        Arrays.sort(result, (a,b)->  Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> allocator = new PriorityQueue(result.length, (a,b)->  Integer.compare((Integer) a, (Integer)b));


            PriorityQueue<String> pq = new PriorityQueue<>();

            // Add strings to the priority queue

        pq.add("cherry");
            pq.add("banana");
            pq.add("dog");
        pq.add("apple");

            // Retrieve and print strings in sorted order
            while (!pq.isEmpty()) {
                System.out.println(pq.poll());
            }



    }

}
