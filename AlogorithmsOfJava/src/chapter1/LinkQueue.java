package chapter1;

public class LinkQueue<Item> {
    private int N;
    private Node head;
    private Node last;
    private LinkQueue<Item> tem ;
    private class Node {
        Item item;
        Node next;
    }
    public boolean isEmpty() {
        return head==null;
    }
    public int size() {
        return N;
    }
    public void enQueue(Item item) {
        Node old = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            head = last;
        }else {
            old.next = last;
        }
        N++;
    }
    public Item deQueue() {
        Item res = head.item;
        head = head.next;
        N--;
        if (isEmpty()) {
            last = null;
        }
        return res;
    }
    public void clear() {
        N=0;
        head=last=null;
    }
    public void catenation(LinkQueue<Item> queue) {
//        this.tem = queue;
        last.next= queue.head;
    }
}
