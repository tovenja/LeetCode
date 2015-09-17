package alibaba.online.test;

/**
 * Created by blank on 2015-08-23 上午10:49.
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] array = new int[]{88, 459, 5262, 88, -17, 667, 88, 667, -17, 459, 5262};
        int res = findThree(array);
        System.out.println(res);
    }

    static int findThree(int[] nums) {
        int res = 0;
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
