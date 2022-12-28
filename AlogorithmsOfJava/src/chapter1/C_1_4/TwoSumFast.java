package chapter1.C_1_4;

import java.util.Arrays;

public class TwoSumFast{

    public static int count(int[] a){
        int N = a.length;
        Arrays.sort(a);
        int cnt = 0;
        for (int i = 0; i < N; i++)
            if (rank(-a[i], a) > i)
                cnt++;
        return cnt;
    }

    public static int rank(int key, int[] a)
    { // 二分查找
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        { // 键要么存在于 a[lo..hi] 中，要么不存在
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
class ThreeSumFast{
    public static int count(int[] a){
        int N = a.length;
        Arrays.sort(a);
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                if (TwoSumFast.rank(-a[i]-a[j], a) > j)
                    cnt++;
        return cnt;
    }
}