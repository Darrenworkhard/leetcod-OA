/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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