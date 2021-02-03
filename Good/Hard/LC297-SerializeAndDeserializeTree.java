/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74260/Recursive-DFS-Iterative-DFS-and-BFS
public class Codec {

    StringBuilder sb = new StringBuilder();
    TreeNode retNode = new TreeNode();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfsSerialize(root);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return dfsDeserialize(data_list);
    }
    
    void dfsSerialize(TreeNode node)
    {
        if(node == null)
        {
            sb.append("null,");
            return;
        }
        sb.append(node.val+",");
        dfsSerialize(node.left);
        dfsSerialize(node.right);
    }
    
    TreeNode dfsDeserialize(List<String> list)
    {
        if(list.get(0).equals("null"))
        {
            list.remove(0);
            return null;
        }
            
        
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = dfsDeserialize(list);
        root.right = dfsDeserialize(list);
        return root;
            
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));


public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        TreeNode x=root;
        Deque<TreeNode> stack=new LinkedList<>();
        while (x!=null || !stack.isEmpty()) {
            if (x!=null) {
                sb.append(String.valueOf(x.val));
                sb.append(' ');
                stack.push(x);
                x=x.left;
            }
            else {
                sb.append("null ");
                x=stack.pop();
                x=x.right;
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length()==0) return null;
        String[] node=data.split(" ");
        int n=node.length;
        Deque<TreeNode> stack=new LinkedList<>();
        //Point
        TreeNode root=new TreeNode(Integer.valueOf(node[0]));
        TreeNode x=root;
        stack.push(x);
        
        int i=1;
        while (i<n) {
            while (i<n && !node[i].equals("null")) {
                x.left=new TreeNode(Integer.valueOf(node[i++]));
                x=x.left;
                stack.push(x);
            }
            while (i<n && node[i].equals("null")) {
                x=stack.pop();
                i++;
            }
            if (i<n) {
                x.right=new TreeNode(Integer.valueOf(node[i++]));
                x=x.right;
                stack.push(x);
            }
        }
        return root;
    }
}