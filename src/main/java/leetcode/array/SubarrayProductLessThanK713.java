package leetcode.array;

/**
 * @author blank
 * @Description
 * @Date 创建于 18-4-8 下午3:51
 */
public class SubarrayProductLessThanK713 {
    
    public static void main(String[] args) {
        int[] arr = new int[] {10, 5, 2, 6};
        new SubarrayProductLessThanK713().numSubarrayProductLessThanK(arr, 100);
    }
    
    /**
     * Sliding window
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod = 1, ans = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            prod *= nums[i];
            while (j <= i && prod >= k) {
                prod /= nums[j++];
            }
            ans += i - j + 1;
        }
        return ans;
    }
    
    /**
     * brute force, TLE
     */
    public int numSubarrayProductLessThanK_(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (i == j && nums[i] < k) {
                    ans++;
                    continue;
                }
                tmp *= nums[j];
                if (tmp < k) {
                    ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
