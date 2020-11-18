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
    int sum = 0;
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return sum;
    }
    int dfs(TreeNode root)
    {
        int l = 0;
        int r = 0;
        if(root.left != null)
            l = dfs(root.left);
        if(root.right != null)
            r = dfs(root.right);
        int val = Math.abs(l - r);
        sum += val;
        return l + r + root.val;
        
    }
    
}