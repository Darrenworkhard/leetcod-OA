public class LC110_BalancedBinaryTree {
    //S1 O(N)
    boolean balance = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        bfs(root, 0);
        
        return balance;
    }
    public int bfs(TreeNode root, int deep)
    {
        if(root == null) return deep;
        
        int l = bfs(root.left, deep+1);
        int r = bfs(root.right, deep+1);
        
        int max = Math.max(l,r);
        int min = Math.min(l,r);
        
        if(max - min > 1)
            balance = false;
        
        return max;
     
    }
    //S2 O(N)
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return balance(root) > 0;
    }
    public int balance(TreeNode root)
    {
        if(root == null) return 0;

        int l = balance(root.left);
        int r = balance(root.right);
        if(l == -1) return -1;
        if(r == -1) return -1;
        
        if(Math.abs(l - r) > 1) return -1;
        
        return Math.max(l,r) + 1;
        
    }
    //S3 O(N2)
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return isBalance(root);
    }
    boolean isBalance(TreeNode root)
    {
        if(root == null) return true;
        int l = checkDeep(0, root.left);
        int r = checkDeep(0, root.right);
        
        if(Math.abs(l - r) > 1)
            return false;
        
        return isBalance(root.left) && isBalance(root.right);
    }
    int checkDeep(int level, TreeNode node)
    {
        if(node == null)
            return level;
        
        return Math.max(checkDeep(level+1, node.right), checkDeep(level+1, node.left));
    }
}
