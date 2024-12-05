package lld.snakeandladder.model;

public class SpecialEntity {
    int head;

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    int tail;
    public SpecialEntity(int head, int tail){
        this.head=head;
        this.tail=tail;
    }
}
