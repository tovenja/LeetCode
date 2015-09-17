package leetcode.BinarySearch;

/**
 * Created by blank on 2015-09-08 下午7:10.
 */
public class FirstBadVersion {

    public static void main(String[] args) {

        System.out.println((2 + 3) >>> 1);
        int res = firstBadVersion(4);
        System.out.println(res);
    }


    public static int firstBadVersion(int n) {
        if (n == 1) {
            return 1;
        }
        if (isBadVersion(1)){
            return 1;
        }
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (!isBadVersion(mid + 1) && isBadVersion(mid + 2)) {
                return mid + 2;
            }
            if (!isBadVersion(mid) && isBadVersion(mid + 1)) {
                return mid + 1;
            } else if (isBadVersion(mid + 1)) {
                hi = mid - 1;
            } else if (!isBadVersion(mid + 1)) {
                lo = mid + 1;
            }
        }
        return -1;
    }

    private static boolean isBadVersion(int n) {

        return false;
    }
}
