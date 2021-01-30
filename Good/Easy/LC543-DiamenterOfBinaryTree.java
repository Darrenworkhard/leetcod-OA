public class LC543-DiamenterOfBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }
    int dfs(TreeNode node)
    {
        if(node == null)
            return 0;
        
        int l = dfs(node.left);
        int r = dfs(node.right);
        
        max = Math.max(max, l+r);
        
        return Math.max(l+1, r+1);
    }
}
