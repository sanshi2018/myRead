package chapter1;

import java.util.Iterator;
import java.util.Scanner;

public class pushItem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkQueue<String> linkStack = new LinkQueue<>();
        while (in.hasNextLine()){
            String[] strs = in.nextLine().split(" ");
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].equals("-")){
                    System.out.println(linkStack.deQueue());
                }else {
                    linkStack.enQueue(strs[i]);
                }
            }
//            Iterator<String > iterator = linkStack.iterator();
//            while (iterator.hasNext()){
//                System.out.print(iterator.next());
//            }
            System.out.println("(" +linkStack.size()+ " left on stack");
            linkStack.clear();
        }
    }
}
