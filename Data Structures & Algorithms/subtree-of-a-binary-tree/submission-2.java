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
    boolean res = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;
        if (root.val == subRoot.val) {
            res = res || isSubtreeEqual(root,subRoot);
        }
        isSubtree(root.left, subRoot);
        isSubtree(root.right, subRoot);
        return res;
    }    

    public boolean isSubtreeEqual(TreeNode root, TreeNode subroot){
        if (root== null && subroot == null) return true;
        if(root==null || subroot==null || root.val != subroot.val) return false;
        return isSubtreeEqual(root.left, subroot.left) && isSubtreeEqual(root.right, subroot.right);
    }
}
