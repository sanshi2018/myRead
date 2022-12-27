package chapter1.C_1_4;

public class BinarySearch {
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
