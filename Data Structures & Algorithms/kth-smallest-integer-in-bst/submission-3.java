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

    public int kthSmallest(TreeNode root, int k) {
        return dfs(root, k );
    }

    public int dfs(TreeNode root , int k){
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while(root!=null || !stack.isEmpty()){
            if (k == 0) return 0;
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            k--;
            TreeNode curr = stack.pop();
            if(k==0) return curr.val;
            root = curr.right;
            
        }
        return 0;
    }


}
