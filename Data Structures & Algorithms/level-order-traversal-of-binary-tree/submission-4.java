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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //algo
        //queue
        //res 
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();

        q.push(root);                   // 1 
        while(!q.isEmpty()){
            int size = q.size();            // 1 
            //System.out.println(size);
            List<Integer> level = new ArrayList<Integer>();
            for (int i= 0 ; i<size; i++){
                    TreeNode curr = q.poll();  
                    level.add(curr.val);
                    if(curr.left!=null) q.add(curr.left);
                    if(curr.right!=null) q.add(curr.right);
            }
             if (level.size() > 0) {
            result.add(level);}
        }
        return result;
    }
}
