package alibaba.online.test;

/**
 * Created by blank on 2015-08-23 上午10:28.
 */
public class BSearch {


    public static void main(String[] args) {
        int[] ar = new int[]{2, 6, 8, 10, 13, 25, 36, 45, 53, 76, 88, 100, 127};
        bSearch(ar, 13, 127);
    }

    static int bSearch(int array[], int n, int v) {
        int left, right, middle;
        left = 0;
        right = n - 1;
        int cnt = 1;
        while (left <= right) {
            System.out.println(cnt++);
            middle = left + (right - left) / 2;
            if (array[middle] > v) {
                right = middle;
            } else if (array[middle] < v) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
