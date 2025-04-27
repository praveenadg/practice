package problems.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyHashMap {

    static class Node<U, V> {
        public U key;
        public V val;

        public Node(U key, V val) {
            this.key = key;
            this.val = val;
        }
    }
    static class Bucket{
        private List<Node<Integer, Integer>> nodes;
        public Bucket(){
            this.nodes = new LinkedList<>();
        }

        public Integer get(Integer key) {
            for (Node<Integer, Integer> pair : this.nodes) {
                if (pair.key.equals(key))
                    return pair.val;
            }
            return -1;
        }

        public void update(Integer key, Integer value) {
            for (Node<Integer, Integer> pair : this.nodes) {
                if (pair.key.equals(key)) {
                    pair.val = value;
                    return;
                }
            }
            this.nodes.add(new Node<Integer, Integer>(key, value));
        }

        public void remove(Integer key) {
            for (Node<Integer, Integer> pair : this.nodes) {
                if (pair.key.equals(key)) {
                    this.nodes.remove(pair);
                    break;//won't throw CME
                }
            }
        }
    }

    List<Bucket> buckets;

    private final int key_space;
    public MyHashMap() {
        this.key_space=2069;
        buckets = new ArrayList<>();
        for (int i = 0; i < this.key_space; ++i) {
            this.buckets.add(new Bucket());
        }
    }

    public void put(int key, int value) {
        int hash_key = key % key_space;
        this.buckets.get(hash_key).update(key, value);
    }

    public int get(int key) {
        int hash_key=key%key_space;
        return this.buckets.get(hash_key).get(key);

    }

    public void remove(int key) {
        int hash_key=key%key_space;
        this.buckets.get(hash_key).remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */