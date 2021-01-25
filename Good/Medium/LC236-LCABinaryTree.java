package Good.Medium;
import java.util.*;

public class LC236-LCABinaryTree {
        
       /**
         * Definition for a binary tree node.
         * public class TreeNode {
         *     int val;
         *     TreeNode left;
         *     TreeNode right;
         *     TreeNode(int x) { val = x; }
         * }
       */

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            
            return dfs(root, p, q);
        }
        public TreeNode dfs(TreeNode node, TreeNode p, TreeNode q)
        {
            if(node == null)
                return null;
            if(node.val == p.val) return p;
            if(node.val == q.val) return q;
            TreeNode l = dfs(node.left, p, q);
            TreeNode r = dfs(node.right, p, q);
            
            if(l != null && r != null)
                return node;
            
            return l == null ? r : l;
        }
}
