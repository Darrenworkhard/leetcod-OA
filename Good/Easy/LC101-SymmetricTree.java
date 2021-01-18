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

 //1
 class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
        return dfs(root.left, root.right);
            
    }
    boolean dfs(TreeNode l, TreeNode r)
    {
        if(l == null && r == null) return true;
        if(l == null || r == null) return false;
        return l.val == r.val && dfs(l.left, r.right) && dfs(l.right, r.left);
    }
}
//2
public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
        TreeNode t1 = q.poll();
        TreeNode t2 = q.poll();
        if (t1 == null && t2 == null) continue;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        q.add(t1.left);
        q.add(t2.right);
        q.add(t1.right);
        q.add(t2.left);
    }
    return true;
}
//3
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++)
            {
                TreeNode node = q.poll();
                if(node.right != null)
                {
                    q.add(node.right);
                    list.add(node.right.val);
                }
                else
                {
                    list.add(null);
                }
                    
                if(node.left != null)
                {
                    q.add(node.left);
                    list.add(node.left.val);
                }
                else
                {
                     list.add(null);
                } 
            }
            if(!checkSymmetric(list))
                return false;
        }
        return true;
    }
    boolean checkSymmetric(List<Integer> list)
    {
        int i = 0;
        int j = list.size() -1;
        while(i < j)
        {
            Integer l = list.get(i);
            Integer r = list.get(j);
            if(l != r)
                return false;
            i++;
            j--;
        }
        return true;
    }
    
    
    
    
    
    
    
}