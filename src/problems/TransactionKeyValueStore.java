package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

//https://medium.com/@rickymondal/system-design-inmemory-key-value-with-transaction-0a6df97ccce1
public class TransactionKeyValueStore {

    /**
     * Allows each thread to have its own transaction context.
     * Ensures thread safety for concurrent transactions.
     */
    ThreadLocal<Transaction> currentTransaction;

    Map<String, TransactionVersion> data;
    /**
     * A global counter for generating unique version numbers.
     * AtomicLong ensures thread-safe increments.
     */
    private final AtomicLong globalVersion = new AtomicLong(0);

    public TransactionKeyValueStore(ThreadLocal<Transaction> currentTransaction, Map<String, TransactionVersion> data) {
        this.currentTransaction = currentTransaction;
        this.data = data;
    }

    public static void main(String args[]){

}
    // A Transaction class to hold reamMap, writeMap, and deleteKeysSet
    static class Transaction {
        Map<String, TransactionVersion> readMap = new HashMap<>();
        Map<String, String> writeMap = new HashMap<>();
        Set<String> deleteKeys = new HashSet<>();

        public Transaction(Map<String, TransactionVersion> readMap, Map<String, String> writeMap, Set<String> deleteKeys) {
            this.readMap = readMap;
            this.writeMap = writeMap;
            this.deleteKeys = deleteKeys;
        }
    }
//wrapper class for data with a version
    static class TransactionVersion{
        long versionNumber;
        String data;

        public TransactionVersion(long versionNumber, String data) {
            this.versionNumber = versionNumber;
            this.data = data;
        }
    }

    //Records the read in the transaction's readMap for later conflict detection.
    public String get(String key){
        Transaction current = currentTransaction.get();
        if(current!=null){
            if (current.deleteKeys.contains(key)) return null;
            if (current.writeMap.containsKey(key))
                return current.writeMap.get(key);
        }
        TransactionVersion version = data.get(key);//read from main memory and add it to transaction
        if( version!=null){
            if(current!=null){
                current.readMap.put(key, version);
            }
            return  data.get(key).data;
        }
        return null;
    }

public void put(String key, String value){
        Transaction current = currentTransaction.get();
    if(current!=null){
        current.deleteKeys.remove(key);
        //current.readMap.put(key, new TransactionVersion(globalVersion.incrementAndGet(), value));
        current.writeMap.put(key,value);
    } else {
        data.put(key, new TransactionVersion(globalVersion.incrementAndGet(), value));
    }

    }

    public void delete(String key) {
        Transaction current = currentTransaction.get();
        if(current!=null){
            current.deleteKeys.add(key);
            current.writeMap.remove(key);
            //current.readMap.remove(key);
        } else {
            data.remove(key);
        }
    }
    public void begin(){
        if(currentTransaction.get()!=null)
            throw new RuntimeException("transaction in progress");
        Transaction transaction = new Transaction(new HashMap<>(), new HashMap<>(), new HashSet<>());
        currentTransaction.set(transaction);
    }

    /**
     * Checks for conflicts by comparing versions in the readSet with current versions.
     * If no conflicts, applies changes from deleteSet and writeSet to the main data store.
     * Returns true if the commit was successful, false if there was a conflict.
     * @return
     */
    public boolean commit(){
        if(currentTransaction.get()==null)
            throw new RuntimeException("no active transaction");

        //conflict detection
        Transaction current =currentTransaction.get();
        for(Map.Entry<String, TransactionVersion> entry : current.readMap.entrySet()){
            TransactionVersion currentVersion = entry.getValue();
            if(data.get(entry.getKey()).versionNumber != currentVersion.versionNumber) {
                throw new RuntimeException("conflict detected currentVersion=" + data.get(entry.getKey()).versionNumber + " versionInTransaction=" + currentVersion.versionNumber);
            }
        }

        for(Map.Entry<String, String> entry : current.writeMap.entrySet()){
            data.put(entry.getKey(), new TransactionVersion( globalVersion.incrementAndGet(), entry.getValue()));
        }
        for(String key : current.deleteKeys){
            data.remove(key);
        }
        currentTransaction.remove();

        return true;

    }
    public boolean rollback(){
        if(currentTransaction.get()==null)
            throw new RuntimeException("no active transaction");
        currentTransaction.remove();
        return true;
    }

}
