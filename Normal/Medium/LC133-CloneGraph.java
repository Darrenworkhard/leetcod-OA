/*
// Definition for a Node.
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
*/

//Dfs
class Solution {
    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        Node clone = new Node(node.val);
        map.put(node.val, clone);
        for(int i = 0; i < node.neighbors.size(); i++)
        {
            Node nextNode = node.neighbors.get(i);
            if(!map.containsKey(nextNode.val))
                clone.neighbors.add(cloneGraph(nextNode));
            else
            {
                clone.neighbors.add(map.get(nextNode.val));
            }
        }      
        
        return clone;
    }
}
