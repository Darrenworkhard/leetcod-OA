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

    public int rob(TreeNode root) {
        if(root == null) return 0;
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
     
    }
    
    public int[] dfs(TreeNode root)
    {
        if(root == null)
        {
            int[] ret = new int[]{0,0};
            return ret;
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        
        int[] res = new int[2];
        res[0] = root.val + l[1] + r[1];
        res[1] = Math.max(l[0],l[1]) + Math.max(r[0],r[1]);
        
        return res;
    }
 
}
//S2 slow but easy to think
class Solution {

    public int rob(TreeNode root) {
        if(root == null) return 0;
        int val = root.val;
        if(root.left != null) val += rob(root.left.left) + rob(root.left.right);
        if(root.right != null) val += rob(root.right.left) + rob(root.right.right);
        int val2 = rob(root.left) + rob(root.right);
        
        return Math.max(val, val2);
        
    }
}
   