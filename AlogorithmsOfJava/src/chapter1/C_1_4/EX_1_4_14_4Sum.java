package chapter1.C_1_4;

import java.util.Arrays;

import algs4.Alphabet;
import algs4.BinaryStdIn;
import algs4.In;


public class EX_1_4_14_4Sum {
    public static int count(int[] a) {
        int N = a.length;
        Arrays.sort(a);
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                for (int k = j+1; k < N; k++)
                    if (BinarySearch.rank(-a[i]-a[j]-a[k], a) > k)
                        cnt++;
        return cnt;
    }
    public static void main(String[] args) {
        int[] a = new In(args[0]).readAllInts();
//        System.out.println(count);
    }
}
