package chapter1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EX_1_3_37_Josephus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.add(i);
        }
        int k =0 ;
        while (!queue.isEmpty()){
            int x = queue.poll();
            k++;
            if (k%M == 0){
                System.out.println(x);
                continue;
            }
            queue.add(x);
        }
    }
}
