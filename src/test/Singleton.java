package test;

public class Singleton {

    /**
     * Database Connection Pool
     * Configuration Settings
     * Caching
     * Thread Pool
     */
    private Singleton(){
        s="teest";
    }
    private String s;
    private static int count = 0;

    /**
     * synchronized can be used with static in this case only one thread can access the class level method
     *
     * As alternative to a synchronized block you could guard the code with a Read / Write Lock which as more advanced locking semantics than a synchronized block. Java actually comes with a built in ReadWriteLock class you can use.
     *
     * public class Processor {
     *   private final AtomicReference<Date> startTime = new AtomicReference<Date>();
     *   public void doProcess() {
     *     if (this.startTime.compareAndSet(null, new Date())) {
     *       // do something first time only
     *     }
     *     // do somethings
     *   }
     * }
     *
     * Use atomicInteger.
     * volatile variables which are read from main memory than thread memory.
     * **/
    public static synchronized void add(int value){
        count += value;
    }

    private static Singleton instance=null;

    /**
     * Step 2: Static Instance with Double-Checked Locking
     * We create a static method that provides access to the single instance of the class.
     * We use double-checked locking to ensure thread safety.
     * This technique minimizes synchronization overhead by checking if the instance is null before entering a synchronized block.
     * @return
     */
    public static Singleton getInstance(){
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
