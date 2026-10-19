/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int max_sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        dfs(root);

        return max_sum;
        
    }

    public int dfs(TreeNode root){
        if(root == null) return 0;

        int left_Sum = dfs(root.left);
        int right_Sum = dfs(root.right);
        int curr = left_Sum + right_Sum + root.val;
        if (max_sum<curr){
            max_sum = Math.max(curr, root.val);
        }            
        return Math.max(Math.max(left_Sum, right_Sum)+ root.val, 0);
    }
}
