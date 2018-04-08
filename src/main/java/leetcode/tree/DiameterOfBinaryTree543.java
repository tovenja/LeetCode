package leetcode.tree;

import leetcode.define.TreeNode;

/**
 * @author 杨立群
 * @Description
 * @Date 创建于 18-4-8 下午5:32
 */
public class DiameterOfBinaryTree543 {
    int ans = 0;
    
    /**
     * 计算二叉树最长路径长度。
     * 思路：遍历二叉树算出每一个节点最深的左右子树的深度，经过当前节点最长的路径就是左右最深子树的路径。
     * 遍历过程中就可以发现最长路径长度。
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return ans;
    }
    
    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftLevel = maxDepth(node.left);
        int rightLevel = maxDepth(node.right);
        ans = Math.max(ans, leftLevel + rightLevel);
        return Math.max(leftLevel, rightLevel) + 1;
    }
    
}
