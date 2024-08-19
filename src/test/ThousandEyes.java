package test;

import java.util.HashMap;
import java.util.Map;

/*
Acme Corp  wants to implement a new web browser. To improve subsequent page loads, they need to implement a cache
for the static assets loaded on the page. For their initial implementation they just want to honor the "Expires"
header provided in the http responses for those assets, so that they never return cached assets after they're expired.

Can you help Acme Corp implement this cache?

Goal:
- Help Acme Corp implement their caching logic

API:
    Constructor:
        Capacity - the maximum number of values the cache can hold
    Methods:
        get(key) -> value if (value_exists and not expired) else None
        set(key, value, expiryTime) // Will evict the soonest to expire entry if at capacity

    Data Format:
        key: String
        value: String
        expiryTime: Number (Unix timestamp)

Assumptions:
- All data supplied to the cache will be provided with an associated expiry timestamp.
- Our cache does not require any knowledge about HTTP or networking concepts. It will just work off of the supplied expiry time.
- Assume there are no duplicate expiry times
*/

// Your previous Plain Text content is preserved below:

// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you'd like to use for your interview,
// simply choose it from the dots menu on the tab, or add a new language
// tab using the Languages button on the left.

// You can also change the default language your pads are created with
// in your account settings: https://app.coderpad.io/settings

// Enjoy your interview!

class Solution {
    int cap;
    Map<String, Node> cache;
    Node head;
    Node tail;

    class Node {
        Node next;
        Node prev;
        String key;
        String val;
        long expiryTime;
        Node(String key, long expiryTime, String val){
            this.key=key;
            this.expiryTime=expiryTime;
            this.val=val;
        }
    }



    public Solution(int capacity){
        this.cap=capacity;
        cache=new HashMap<>(capacity);
        head = new Node("", 0, "");
        tail = new Node("", 0, "");
        head.next=tail;
        tail.prev=head;

    }

    public String get(String key){

        Node node =cache.get(key);
        if(node!=null && !isExpired(node.expiryTime)){
            return node.val;
        }
        return null;

    }

    private boolean isExpired(long expiryTime){
        return System.currentTimeMillis() > expiryTime;
    }

    private void add(Node node){
        Node currentTail = tail.prev;
        tail.prev=node;
        node.next=tail;
        node.prev=currentTail;
        currentTail.next=node;

    }
    private void delete(Node node){
        //remove the first node from head
        if(node!=tail){
            Node nextNode = node.next;
            head.next=nextNode;
            nextNode.prev=head;
        }

    }

    public void set(String key, String value, long expiryTime){
        Node node = new Node(key, expiryTime, value);
        if(cache.size()<cap){
            cache.put(key, node);
            add(node);

        } else {
            cache.remove(head.next.key);
            delete(head.next);
            add(node);
            cache.put(key, node);

        }


    }

    public static void main(String[] args) {
            System.out.println(Math.pow(2,268435455));
        System.out.println((int)Math.floor(14/15.00));
        System.out.println((int)Math.ceil(31/15.00));
        System.out.println((int)Math.ceil(3/2.00));

        Solution solution= new Solution(3);
        solution.set("key1", "value1", (System.currentTimeMillis()+10000));
        solution.set("key2", "value2", (System.currentTimeMillis()+1000));
        solution.set("key3", "value3", (System.currentTimeMillis()+1000));
        try{
            Thread.sleep(1000);
            //solution.set("key3", "value3", (System.currentTimeMillis()+1000));

            System.out.println(solution.get("key1"));
            System.out.println(solution.get("key2"));
            System.out.println(solution.get("key3"));
        } catch(InterruptedException ir){

        }
    }
}

