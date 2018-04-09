package leetcode.array;

/**
 * @author blank
 * @Description
 * @Date 创建于 18-4-9 下午4:47
 */
public class MaximumAverageSubarrayI643 {
    public static void main(String[] args) {
        System.out.println(new MaximumAverageSubarrayI643().findMaxAverage(new int[] {-1}, 1));
    }
    
    /**
     * sliding window，注意保证sum一定得是k窗口大小的和才行。
     */
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return max / k;
    }
}
