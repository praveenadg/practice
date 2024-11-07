package problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * if we use list removing from list is O(n) use linkedList to remove
 */
class LRUCache {

    List<Integer> list;
    //Map<Integer, Integer> map;
    Map<Integer, Integer> hashMap;
    int cap;

    public LRUCache(int capacity) {
        list= new LinkedList<>();
        // map = new HashMap(capacity);
        hashMap = new HashMap<>(capacity);
        cap=capacity;
    }

    public int get(int key) {
        if(hashMap.containsKey(key)){
            updateList(key);
            return hashMap.get(key);
        }
        // hashMap.put(key, hashMap.getOrDefault(key, 0)+1);
        return -1;
    }

    public void updateList(int key){
        list.remove(new Integer(key));
        list.add(new Integer(key));
    }

    public void put(int key, int value) {
        if(hashMap.containsKey(key)){
            hashMap.put(key, value);
            updateList(key);
            return;
        }
        if(hashMap.size()==cap){
            if (list.size()>0){
                hashMap.remove(list.get(0));
                list.remove(0);
            }
        }
        // map.put(key, value);
        hashMap.put(key, value);
        updateList(key);

    }

    public static void main(String args[]){
        LRUCache obj = new LRUCache(2);
        //int param_1 = obj.get(1);
        //System.out.println(param_1);
        obj.get(2);
        obj.put(2,6);
        obj.get(1);
        obj.put(1,5);
        obj.put(1,2);
        obj.get(1);
        obj.get(2);
        //obj.get(4);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */