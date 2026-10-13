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



// 
class Solution {    // 1.r,3.r,4.l
    int depth = 0 ; // 2
    int max =0;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            max = Math.max(depth,max); 
            return max;
            }
            else{ depth++; }
       
        maxDepth(root.left);
        maxDepth(root.right);  
        depth--; 
        return max;   
    }
}


 