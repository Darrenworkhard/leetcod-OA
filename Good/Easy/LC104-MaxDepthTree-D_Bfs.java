/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        return bfs(root, 0);
        
    }
    public int bfs(TreeNode root, int deep)
    {
        if(root == null) return deep;
 
        return Math.max(bfs(root.left, deep+1), bfs(root.right, deep+1));
    }
}