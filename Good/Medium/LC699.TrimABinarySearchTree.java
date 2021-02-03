package Good.Medium;

class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        
        return dfs(root, low, high);
    }
    TreeNode dfs(TreeNode node, int low, int height)
    {
        if(node == null)
            return null;
        if(node.val < low || node.val > height)
        {
            if(node.right != null && node.right.val >= low && node.right.val <= height)
            {
                node = node.right;
                node = dfs(node, low, height);
            }
            else if(node.left != null && node.left.val >= low && node.left.val <= height)
            {
                node = node.left;
                node = dfs(node, low, height);
            }
            else
            {
                TreeNode l = dfs(node.left, low, height);
                TreeNode r = dfs(node.right, low, height);
                if(l != null || r != null)
                {
                    node = l == null ? r : l;
                }
                else
                {
                    node = null;
                }     
            }      
        }
        else
        {
            node.right = dfs(node.right, low, height);
            node.left = dfs(node.left, low, height);
        }
        return node;
    }
}
//S2
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        
        if (root.val > high) return trimBST(root.left, low, high);
        if (root.val < low) return trimBST(root.right, low, high);
        
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        
        return root;
    }
}