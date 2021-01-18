//BFS
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        
        Queue<TreeNode> q = new LinkedList<>(); 
        q.add(root);
        boolean even = true;
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++)
            {
                TreeNode node = q.poll();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                
                if(even)
                {
                    list.add(node.val);
                }
                else
                {
                    list.add(0, node.val);
                }
            }
            ret.add(list);
            even = !even;
        }
        return ret;
    }
}
//DFS
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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return ans;
        
        bfs(root, 0);
        //ans.get(0).addAll(list);
        
        return ans;
    }
    void bfs(TreeNode root, int level)
    {
        if(root == null) return;
        if(ans.size() == level)
            ans.add(new ArrayList<Integer>());
        
        if(level % 2 != 0)
        {
           ans.get(level).add(0, root.val);
        }
        else
        {
           ans.get(level).add(root.val);            
        }
        
        bfs(root.left, level + 1);
        bfs(root.right, level + 1);
        
       
         
    }
}