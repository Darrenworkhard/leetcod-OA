//Average O(1) time and use O(h) memory
//Time from O(1) ~ O(n)
class BSTIterator {
    Stack<TreeNode> s = new Stack<>();
    void pushLeft(TreeNode node)
    {
        s.add(node);
        if(node.left != null)
            pushLeft(node.left);
    }

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }
    
    public int next() {
        TreeNode ret = s.pop();
        if(ret.right != null)
        {
            pushLeft(ret.right);
        }
        return ret.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
}
//Flattening BST
class BSTIterator {

    TreeNode node = new TreeNode();
    //You can chage to list, it's easy to impliment.
    TreeNode dummy = node;
    List<Integer> list = new ArrayList<>();
    public BSTIterator(TreeNode root) {
        dfs(root);
        for(int i : list)
        {
            dummy.right = new TreeNode(i);
            dummy = dummy.right;
        }
    }
    
    public int next() {
        node = node.right;
        return node.val;
    }
    
    public boolean hasNext() {
        return node.right != null;
    }
    void dfs(TreeNode node)
    {
        if(node == null) return;
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
}
