package chapter1;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LinkStack<Item> implements Iterable{
    private int N;
    private Node first;
    private volatile int modCount = 0;

    /**
     * Exercise 1.3.42
     */
    private class Node {
        Item item;
        Node next;
        Node(){

        }
        Node(Node node){
            item = node.item;
            if (node.next!=null){
                next=node.next;
            }
            N++;
        }
    }
    public LinkStack(){
        first=null;
        N=0;
    }

    public LinkStack(LinkStack linkStack){
        first = new Node(linkStack.first);
    }
    public boolean isEmpty() {
        return first==null;
    }
    public int size() {
        return N;
    }
    public void push(Item item) {
        Node old = first;
        first = new Node();
        first.item=item;
        first.next = old;
        N++;
        modCount++;
    }
    public Item pop() {
        if (first==null) return null;
        Item res = first.item;
        first = first.next;
        N--;
        modCount++;
        return res;
    }
    public void clear() {
        first = null;
        N = 0;
    }
    public void catenation(LinkStack<Item> linkStack){
        if (first==null) return;
        Node last = linkStack.first;
        while (last.next!=null) {
            last = last.next;
        }
        last.next = first;
        first = linkStack.first;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkIterator();
    }
    private class LinkIterator implements Iterator<Item> {
        private Node cur = first;
        private int count = modCount;
        @Override
        public boolean hasNext() {
            if (count!=modCount) throw new ConcurrentModificationException();
            return cur != null;
        }

        @Override
        public Item next() {
            if (count!=modCount) throw new ConcurrentModificationException();
            Item res = cur.item;
            cur = cur.next;
            return res;
        }

        @Override
        public void remove() {

        }
    }
}
