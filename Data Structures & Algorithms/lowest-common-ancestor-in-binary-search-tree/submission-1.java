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
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return new TreeNode();
        if((p.val <=root.val && root.val<=q.val || q.val<=root.val && root.val<=p.val )&& result ==null) result = root;
        lowestCommonAncestor(root.left, p, q);
        lowestCommonAncestor(root.right, p, q);

        return result;
        
    }

}
