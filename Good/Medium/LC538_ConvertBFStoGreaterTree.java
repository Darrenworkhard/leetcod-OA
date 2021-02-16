package Good.Medium;
import java.util.*;
import Stracture.TreeNode;

public class LC538_ConvertBFStoGreaterTree {
    int sum = 0;
    //T:O(n) S:O(n)
    public TreeNode convertBST_S1(TreeNode root) {
        dfs(root);
        return root;
    }
    void dfs(TreeNode node)
    {
        if(node == null)
            return;
        
        dfs(node.right);
        node.val += sum;
        sum = node.val;
        dfs(node.left);
    }

    //BFS dive to right first
    //T:O(n) S:O(n)
    public TreeNode convertBST_S2(TreeNode root) {

        if(root == null) return root;
        //point
        TreeNode node = root;
        Deque<TreeNode> dq = new LinkedList<>();
        while(node != null || !dq.isEmpty())
        {
            while(node != null)
            {
                dq.addFirst(node);
                node = node.right;  
            }
            node = dq.pollFirst();
            node.val += sum;
            sum = node.val;
            //point
            node = node.left;
        }
        return root;
    }

    //T:O(n) S:O(1)
    
}

