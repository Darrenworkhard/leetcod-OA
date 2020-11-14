//S1
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
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        dfs(root, root.val, root.val);
        return ans;
    }
    void dfs(TreeNode root, int curretMax, int currentMin)
    {
        if(root == null) return;
        int current = Math.max(Math.abs(curretMax-root.val), Math.abs(currentMin-root.val));
        curretMax = Math.max(curretMax, root.val);
        currentMin = Math.min(currentMin, root.val);
        ans = Math.max(current, ans);
        dfs(root.left, curretMax, currentMin);
        dfs(root.right, curretMax, currentMin);
    }
}

//S2
class Solution {
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        int[] array = new int[]{root.val, root.val};
        dfs(root, array);
        return ans;
    }
    int[] dfs(TreeNode root, int[] array)
    {
        if(root == null) return array;
        int[] temp = new int[2];
        temp[0] = array[0];
        temp[1] = array[1];
        if(root.left != null)
        {
            array[0] = Math.min(array[0], root.left.val);
            array[1] = Math.max(array[1], root.left.val);
            dfs(root.left, array);
        }
        ans = Math.max(Math.abs(root.val - array[0]), ans);
        ans = Math.max(Math.abs(root.val - array[1]), ans);
        array = temp;
        if(root.right != null)
        {
            array[0] = Math.min(array[0], root.right.val);
            array[1] = Math.max(array[1], root.right.val);
            dfs(root.right, array);
        }
        ans = Math.max(Math.abs(root.val - array[0]), ans);
        ans = Math.max(Math.abs(root.val - array[1]), ans);
        return array;
    }
}