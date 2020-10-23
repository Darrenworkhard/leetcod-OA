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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        return dfs(root,1);
    }
    int dfs(TreeNode root, int deep)
    {
        if(root.left == null && root.right == null)
            return deep;
        
        int l = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;
        
        if(root.left != null)
            l = dfs(root.left, deep+1);
        if(root.right != null)
            r = dfs(root.right, deep+1);
        
        return Math.min(l,r);
    }
}