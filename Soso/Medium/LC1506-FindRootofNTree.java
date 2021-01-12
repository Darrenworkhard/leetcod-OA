/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node findRoot(List<Node> tree) {
        if(tree.size() == 0) return new Node();
        HashSet<Integer> set = new HashSet<>();
        for(Node node : tree)
        {
            for(Node child : node.children)
                set.add(child.val);
        }
        Node ret = null;
        for(Node node : tree)
        {
            if(!set.contains(node.val))
                ret = node;
        }
        return ret;
    }
}