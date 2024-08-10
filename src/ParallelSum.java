import java.util.concurrent.*;

public class ParallelSum {
    public static void main(String[] args) {
        int[] array = createLargeArray();
        int numThreads = Runtime.getRuntime().availableProcessors(); // Get the number of available CPU cores
        System.out.println("nu of cores="+numThreads);
        ExecutorService executor = Executors.newFixedThreadPool(numThreads); // Create a thread pool

        int chunkSize = array.length / numThreads; // Calculate chunk size for each thread

        // Submit tasks to the thread pool
        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == numThreads - 1) ? array.length : (i + 1) * chunkSize;
            Runnable task = new SumTask(array, startIndex, endIndex);
            executor.submit(task);
        }

        executor.shutdown(); // Shut down the thread pool

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS); // Wait for all tasks to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Create a large array
    private static int[] createLargeArray() {
        int size = 10000000; // 10 million elements
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    // Task to calculate sum of elements in a chunk of the array
    static class SumTask implements Runnable {
        private final int[] array;
        private final int startIndex;
        private final int endIndex;

        public SumTask(int[] array, int startIndex, int endIndex) {
            this.array = array;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public void run() {
            long sum = 0;
            for (int i = startIndex; i < endIndex; i++) {
                sum += array[i];
            }
            System.out.println("Sum of elements in range [" + startIndex + ", " + endIndex + "): " + sum);
        }
    }
}