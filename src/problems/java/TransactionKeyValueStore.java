package problems.java;

import java.util.HashMap;
import java.util.Map;

public class TransactionKeyValueStore {

    static class Transaction {
        Map<String, String> store = new HashMap<String, String>();
        Transaction next;
    }

    static class TransactionStack {
        Transaction top;
        int size;

    }

    Map<String, String> globalStore = new HashMap<>();
    TransactionStack stack = new TransactionStack();


    void beginTransaction() {
        Transaction t = new Transaction();
        t.next = stack.top;
        stack.top = t;
        stack.size++;
    }
    void endTransaction() {
        Transaction t = stack.top;

    }

    void commit(){
        Transaction current = stack.top;
        while (current != null) {
            globalStore.putAll(current.store);
            current=current.next;
        }
    }

    void rollback() {
        if(stack.top!=null) {
            stack.top.store.clear();
        }
    }

    String get(String key) {
        Transaction t =stack.top;
        if(t!=null){
            return t.store.get(key);
        }
        return globalStore.get(key);
    }

    void set(String key, String value) {
        Transaction t = stack.top;
        if(t!=null){
            t.store.put(key,value);
        } else {
            globalStore.put(key, value);
        }

    }

    void unset(String key) {
        Transaction t=stack.top;
        if(t.store.containsKey(key)){
            t.store.remove(key);
        } else{
            globalStore.remove(key);
        }
    }
}
