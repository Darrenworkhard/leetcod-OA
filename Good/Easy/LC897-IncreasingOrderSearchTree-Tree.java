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
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return root;
        List<Integer> list = dfs(root, new ArrayList<Integer>());
        return build(0, list.size()-1, list);
        //build tree work also
        // TreeNode dummy = new TreeNode();
        // TreeNode node = dummy;
        // for(int i = 0; i < list.size(); i++)
        // {
        //     node.val = list.get(i);
        //     if(i < list.size()-1)
        //     {
        //         node.right = new TreeNode();
        //         node = node.right;
        //     }
        // }
        // return dummy;
    }
    List<Integer> dfs(TreeNode node, List<Integer> list)
    {
        if(node == null)
            return list;
        if(node.left != null)
            list = dfs(node.left, list);
        list.add(node.val);
        if(node.right != null)
            list = dfs(node.right, list);
        
        return list;
    }
    TreeNode build(int s, int e, List<Integer> list)
    {
        if(s > e)
            return null;
        TreeNode node = new TreeNode(list.get(s));
        node.right = build(s+1, e, list);
        return node;
    }
}