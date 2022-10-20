package chapter1;

public class EX_1_3_14_RezizingArrayQueueOfString<Item> {
    private Item[] items = (Item[]) new Object[1];
    private int N = 0;
    public int size(){return N;};
    public boolean isEmpty() {return N == 0;}
    public void enQueue(Item item) {
        if (N == items.length) {
            resize(items.length*4);
        }
        items[N++] = item;
    }
    public Item deQueue() {
        Item res = items[0];
        for (int i = 0; i < items.length-1; i++) {
            items[i] = items[i+1];
        }
        N--;
        if (N > 0 && N == items.length/4) {
            resize(items.length/2);
        }
        return res;
    }
    private void resize(int max) {}
}
