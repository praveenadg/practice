package problems.java;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorExample {
    public static void main(String args[]) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

        Runnable task = () -> System.out.println("Hello from delayed task!");

        // Schedule the task to run after a delay of 5 seconds
        executor.schedule(task, 5, TimeUnit.SECONDS);

        // Shutdown the executor when done
        executor.shutdown();

        System.out.println(String.join(" ", "ttest"));
        System.out.println("a".repeat(10));
    }

    //ForkJoinPool. commonPool()

    /**
     * Fork-join is particularly good for recursive problems, where a task involves running subtasks and then processing
     * their results. (This is typically called "divide and conquer" ... but that doesn't reveal the essential characteristics.)
     * <p>
     * If you try to solve a recursive problem like this using conventional threading (e.g. via an ExecutorService) you end up
     * with threads tied up waiting for other threads to deliver results to them.
     * <p>
     * On the other hand, if the problem doesn't have those characteristics, there is no real benefit from using fork-join.
     */
    public void completableFutureExample() {
        CompletableFuture.runAsync(() -> System.out.println("Hello from delayed task!"));
    }
}
