public class DeleteMiddleOfLinkedList {

    public static void main(String[] args) {
       // System.out.println(deleteMiddle());
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode deleteMiddle(ListNode head) {

        int size=getSize(head);
        int mid = size/2;
        System.out.println(size);
        System.out.println(mid);

        while(size>0){
            ListNode node = head.next;

            if(size==(mid+1)){
                ListNode temp = head;
                head.next=temp.next.next;
                //head.val=head.next;
            }
            size--;

        }

        return head;
    }
    public int getSize(ListNode head){
        if(head==null){
            return 0;
        }
        return getSize(head.next)+1;
    }
}
