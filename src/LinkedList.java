public class LinkedList {
   static class Node {
        Node prev;
        Node next;
        int val;
        Node(int val){
            this.val=val;
        }
    }

    public static Node reverseLL(Node node){
        Node current=node;
        Node prev=null;
        while(current.next!=null){
            Node next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }

    public static void main(String args[]){
        Node node=new Node(1);
        Node next= new Node(2);
        Node two =  new Node(3);
        next.next=two;
        node.next=next;
        System.out.println((node).val);
        System.out.println(reverseLL(node).val);
    }
}
