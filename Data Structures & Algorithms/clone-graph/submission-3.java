/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

Node - 1 
Neighbours Node 2

Node - 2 
Neighbours Node 1, Node 3

Node - 3
Neighbours Node 2

*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node result = new Node(node.val);
        bfs(node, result);
        return result;
    }

    public void bfs(Node root, Node clone){
        if(root == null) return;
        ArrayDeque<Node> q = new ArrayDeque<>();
        HashMap<Node, Node> map = new HashMap<>();
        q.add(root);
        map.put(root, clone);

        while(!q.isEmpty()){
            Node curr = q.remove();
            for (Node i : curr.neighbors){
                if(!map.containsKey(i)){
                    map.put(i,new Node(i.val));
                    q.add(i);
                }
                map.get(curr).neighbors.add(map.get(i));
            }
            }
            

        }

}