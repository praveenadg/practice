package problems.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class CustomThreadPool {
    int poolSize;
    List<Worker> workerList;
    private final BlockingQueue<Runnable> taskQueue;
    //If a thread tries to retrieve an element from an empty queue, it will block until an element becomes available. Similarly, if a thread tries to add an element to a full queue, it will block until space becomes available

    public CustomThreadPool(int poolSize) {
        this.poolSize = poolSize;
        workerList = new ArrayList<>(poolSize);
        taskQueue = new LinkedBlockingDeque<>();

        for (int i = 0; i < poolSize; i++) {
            Worker thread = new Worker();
            workerList.add(thread);
            thread.start();
        }
    }

    public void submit(Runnable task) throws InterruptedException {
        taskQueue.put(task);
    }

    public void shutdown() {
        workerList.forEach(Worker::stopWorker);
        workerList.forEach(worker -> {
            try {
                worker.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public class Worker extends Thread {
        boolean running = true;

        @Override
        public void run() {
            while (running) {
                try {
                    Runnable task = taskQueue.take();
                    System.out.println("taken " + Thread.currentThread());
                    task.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            System.out.println("stopped " + Thread.currentThread());
        }

        public void stopWorker() {
            running = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CustomThreadPool pool = new CustomThreadPool(20);

        for (int i = 0; i < 50; i++) {
            int taskId = i;
            pool.submit(() -> {
                System.out.println("Task " + taskId + " by " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        pool.shutdown();
    }


}
