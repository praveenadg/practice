package tcs;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String args[]) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.add(1, 1);
        lruCache.add(2, 2);
        lruCache.add(3, 3);
        lruCache.add(4, 4);
        //lruCache.add(5, 5);
        // System.out.println(lruCache.size());
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(4));
        lruCache.add(5, 5);
        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(2));
//        System.out.println(lruCache.get(5));
//        System.out.println(lruCache.get(1));
    }

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void add(int key, int val) {
        Node node = new Node(key, val);
        if (map.containsKey(key)) {
            Node currentNode = map.get(key);
            remove(currentNode);
            map.remove(key);

        }
        if (map.size() == capacity) {
            Node nodeToRemove = head.next;
            remove(nodeToRemove);
            map.remove(nodeToRemove.key);
        }
        add(node);
        map.put(key, node);
    }

    void add(Node node) {
        Node currentTail = tail.prev;
        currentTail.next = node;
        node.prev = currentTail;
        tail.prev = node;
        node.next = tail;
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            add(node);
            return node.value;
        }
        throw new RuntimeException("key not found");
    }

    public int size() {
        return map.size();
    }


}
