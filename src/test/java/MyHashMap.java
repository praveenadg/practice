package test.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyHashMap {

    class Pair<U,V>{
        public U first;
        public V second;
        public Pair(U first, V second){
            this.first=first;
            this.second=second;
        }
    }
    class Bucket{
        private List<Pair<Integer, Integer>> bucket;
        public Bucket(){
            this.bucket = new LinkedList<>();
        }

        public Integer get(Integer key) {
            for (Pair<Integer, Integer> pair : this.bucket) {
                if (pair.first.equals(key))
                    return pair.second;
            }
            return -1;
        }

        public void update(Integer key, Integer value) {
            boolean found = false;
            for (Pair<Integer, Integer> pair : this.bucket) {
                if (pair.first.equals(key)) {
                    pair.second = value;
                    found = true;
                }
            }
            if (!found)
                this.bucket.add(new Pair<Integer, Integer>(key, value));
        }

        public void remove(Integer key) {
            for (Pair<Integer, Integer> pair : this.bucket) {
                if (pair.first.equals(key)) {
                    this.bucket.remove(pair);
                    break;
                }
            }
        }
    }

    List<Bucket> buckets;

    private int key_space;
    public MyHashMap() {
        this.key_space=2069;
        List<Bucket> buckets = new ArrayList<>();
        for (int i = 0; i < this.key_space; ++i) {
            this.buckets.add(new Bucket());
        }
    }

    public void put(int key, int value) {
        int hash_key = key % this.key_space;
        this.buckets.get(hash_key).update(key, value);
    }

    public int get(int key) {
        int hashkey=key%key_space;
        return this.buckets.get(hashkey).get(key);

    }

    public void remove(int key) {
        int hashkey=key%key_space;
        this.buckets.get(hashkey).remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */