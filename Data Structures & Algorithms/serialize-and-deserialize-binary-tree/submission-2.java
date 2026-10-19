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

public class Codec {

    // Encodes a tree to a single string.
    StringBuffer sb = new StringBuffer();

    public String serialize(TreeNode root) {
        if (root == null) {
            sb.append("null,");
            return "";
        }

        sb.append(root.val);
        sb.append(",");
        serialize(root.left);
        serialize(root.right);

        //System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       String[] nodes =  data.trim().split(",");
       System.out.println(Arrays.toString(nodes));
       int[] i = new int[]{0};
       if (nodes[0] == "") return null;
       return dfs(nodes, i);
        
    }

    public TreeNode dfs(String[] nodes, int[] i){
        if(nodes[i[0]].equals("null")) {
            i[0]++;
            return null;

            }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[i[0]]));
        i[0]++;
        node.left =dfs(nodes,i);
        node.right =dfs(nodes,i);

        return node;
    }
}
