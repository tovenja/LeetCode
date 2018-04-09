package leetcode.tree;

import leetcode.define.TreeNode;

import java.util.Arrays;

/**
 * @author 杨立群
 * @Description
 * @Date 创建于 18-4-9 下午4:13
 */
public class MaximumBinaryTree654 {
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int max = findMax(nums);
        TreeNode root = new TreeNode(nums[max]);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, max));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, max + 1, nums.length));
        return root;
    }
    
    private int findMax(int[] nums) {
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[max] < nums[i]) {
                max = i;
            }
        }
        return max;
    }
}
