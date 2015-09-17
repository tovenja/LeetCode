package leetcode.math;

/**
 * Created by blank on 2015-08-19 上午9:33.
 */
public class UglyNumberII {

    public static void main(String[] args) {
        nthUglyNumber(500);
    }


    public static int nthUglyNumber(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] res = new int[n];
        int[] l1 = new int[n];
        int[] l2 = new int[n];
        int[] l3 = new int[n];
        for (int i = 1; i < n; i++) {
            res[i] = Math.min(l1[i] * 2, l2[i] * 3);
            res[i] = Math.min(l3[i] * 5, res[i]);
        }
        return 1;
    }


    public static int nthUglyNumberDummy(int n) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (isUgly(i)) {
                cnt++;
                System.out.println(i);
            }
        }
        System.out.println("cnt:" + cnt);
        return 1;
    }

    static public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        while (true) {
            boolean div = false;
            if (num % 2 == 0) {
                num /= 2;
                div = true;
            }
            if (num % 3 == 0) {
                num /= 3;
                div = true;
            }
            if (num % 5 == 0) {
                num /= 5;
                div = true;
            }
            if (!div) {
                break;
            }
        }
        return num == 1;
    }
}
