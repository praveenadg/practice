package problems;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheNew {

    public static void main(String args[]){
        LRUCacheNew obj = new LRUCacheNew(2);
        //int param_1 = obj.get(1);
        //System.out.println(param_1);

        obj.put(2,"6");
        System.out.println(obj.get(2));//6
        obj.put(1,"5");
        System.out.println(obj.get(1));//5
        obj.put(1,"2");
        System.out.println(obj.get(1));//2
        obj.put(3,"2");
        System.out.println(obj.get(1));//2
        System.out.println(obj.get(2));//null
        //obj.get(4);
    }

    class Node{
        int key;
        String value;
        Node next;
        Node prev;
        public Node(int key, String value){
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> cache = new HashMap<>();
    Node head;
    Node tail;
    int capacity;
    LRUCacheNew(int capacity){
        this.capacity=capacity;
        cache = new HashMap<>(capacity);
        head = new Node(-1, "");
        tail = new Node(-1, "");
        head.next=tail;
        tail.prev=head;
    }

    void add(Node node){
        Node currentTail=tail.prev;
        currentTail.next=node;
        node.prev=currentTail;
        node.next=tail;
        tail.prev=node;
    }
    void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    String get(int key){
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            add(node);
            return node.value;
        }
        return null;
    }
    void put(int key, String value){
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        add(node);
        if(cache.size()>capacity){
            Node nodeToRemove =head.next;
            remove(nodeToRemove);
            cache.remove(nodeToRemove.key);
        }
    }
}
