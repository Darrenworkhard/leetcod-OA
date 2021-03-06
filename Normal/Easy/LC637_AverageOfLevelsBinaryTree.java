package Normal.Easy;
import java.util.*;

public class LC637_AverageOfLevelsBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            double avg = 0;
            for(int i = 0; i < size; i++)
            {
                TreeNode t = q.poll();
                avg += t.val;
                if(t.left != null)
                    q.add(t.left);
                if(t.right != null)
                    q.add(t.right);
                
            }
            if(size > 0)
                ans.add(avg/size);
        }
        return ans;
    }


  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

}
