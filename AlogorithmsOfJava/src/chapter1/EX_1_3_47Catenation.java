package chapter1;


public class EX_1_3_47Catenation {
    public static void main(String[] args) {
        LinkStack<Integer> stack = new LinkStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        LinkStack<Integer> stack2 = new LinkStack<>();
        for (int i = 5; i < 10; i++) {
            stack2.push(i);
        }
        stack.catenation(stack2);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        LinkQueue<Integer> queue = new LinkQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enQueue(i);
        }
        LinkQueue<Integer> queue2 = new LinkQueue<>();
        for (int i = 5; i < 10; i++) {
            queue2.enQueue(i);
        }
        queue.catenation(queue2);
        while (!queue.isEmpty()) {
            System.out.print(queue.deQueue() + " ");
        }
        System.out.println();
    }
}
