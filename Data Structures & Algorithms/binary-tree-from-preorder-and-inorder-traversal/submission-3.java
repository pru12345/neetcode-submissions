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
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     if (preorder.length==0 || inorder.length==0 ) return null;

    //     TreeNode root = new TreeNode(preorder[0]);
    //     int mid = 0;
    //     while (mid <preorder.length && inorder[mid] != root.val ) {
    //         mid++;
    //     }
    //     root.left = buildTree(Arrays.copyOfRange(preorder,1,mid+1), Arrays.copyOfRange(inorder,0,mid));
    //     root.right = buildTree(Arrays.copyOfRange(preorder,mid+1,preorder.length), Arrays.copyOfRange(inorder,mid+1,inorder.length));

    //     return root;

    // }

        HashMap<Integer, Integer> indexes = new HashMap<>();
        int pre_index = 0;

        public TreeNode buildTree(int[] preorder, int[] inorder) {

            for(int i =0; i <inorder.length; i++) indexes.put(inorder[i], i);

            return dfs(preorder, 0, inorder.length - 1);

    }

    public TreeNode dfs(int[] preOrder, int l,int r ){
        if (l>r ) return null;
        int root_val = preOrder[pre_index++];
        int mid = indexes.get(root_val);
        TreeNode root = new TreeNode(root_val);
        root.left = dfs(preOrder, l, mid-1);
        root.right = dfs(preOrder, mid+1 ,r );
        return root;

    }
}
