package Soso.Medium;

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
    TreeNode ret = null;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        dfs(original, cloned, target);
        return ret;
    }
    void dfs(final TreeNode original, final TreeNode cloned, final TreeNode target)
    {
        if(original==null || ret!=null) return;
        if(original == target)
        {
            ret = cloned;
            return;
        }
        if(original.left != null)
            dfs(original.left, cloned.left, target);
        if(original.right != null)
            dfs(original.right, cloned.right, target);
    }
}
