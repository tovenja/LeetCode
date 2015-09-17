package leetcode.bit.manipulation;

import java.util.Arrays;

/**
 * Created by blank on 2015-08-18 下午4:31.
 */
public class SingleNumberIII {

    public static void main(String[] args) {
        int[] res = singleNumber(new int[]{1, 2, 1, 3, 5, 2});
        System.out.println(Arrays.toString(res));
    }

    public static int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            res[0] ^= nums[i];
        }
        int pos = 0;
        for (int i = 0; i < 32; i++) {
            int offset = 1 << i;
            if ((res[0] & (offset)) == offset) {
                pos = i;
                break;
            }
        }
        res[0] = 0;
        int mask = 1 << pos;
        for (int i = 0; i < nums.length; i++) {
            if ((mask & nums[i]) == mask) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}
