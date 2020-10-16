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

    StringBuilder sB = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode t = q.poll();
            sB.append(t.val);
            sB.append(",");
            if(t.left != null)
            {
                q.add(t.left);
            }
            if(t.right != null)
            {
                q.add(t.right);
            }  
        }
        return sB.toString();
    }

    TreeNode tree = null;
    public TreeNode bst(TreeNode tree, int node)
    {
        if(tree == null)
        {
            tree = new TreeNode(node);
            return tree;
        }
        if(tree.val < node)
        {
            tree.right = bst(tree.right, node);
        }
        else if(tree.val > node)
        {
            tree.left = bst(tree.left, node);
        }
        return tree;
        
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] sA = data.split(",");
        for(String s : sA)
        {
            int node = Integer.valueOf(s);
            tree = bst(tree, node);
        }
        return tree;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
