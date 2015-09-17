package leetcode.array;

import java.util.Arrays;

/**
 * Created by blank on 2015-09-08 下午6:12.
 */
public class HIndex {


    public static void main(String[] args) {

        int[] arr = new int[]{1, 2};
        int res = findHIndex(arr);
        System.out.println(res);
    }


    public static int findHIndex(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Arrays.sort(array);
        int len = array.length;
        int pos = len - 1;
        int res = 0;
        while (pos >= 0) {
            int tmp = Math.min(len - pos, array[pos]);
            res = Math.max(res, tmp);
            pos--;
        }
        return res;

    }

}
