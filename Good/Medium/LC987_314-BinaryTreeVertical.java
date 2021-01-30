public class LC987_314-BinaryTreeVertical {
    class Solution {
        HashMap<Integer, PriorityQueue<int[]>> map = new HashMap<>();
        int step = 0;
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> ret = new ArrayList<>();
            if(root == null) return ret;
            dfs(root, 0, 0);
            List<Integer> list = new ArrayList<>(map.keySet());
            Collections.sort(list);
            for(int i : list)
            {
                PriorityQueue<int[]> pq = map.get(i);
                List<Integer> addlist = new ArrayList<>();
                while(!pq.isEmpty())
                {
                    addlist.add(pq.poll()[1]);
                }
                ret.add(addlist);
            }
            return ret;
        }
        void dfs(TreeNode node, int coordinateX, int coordinateY)
        {
            if(node == null)
                return;
            
            //314
            map.putIfAbsent(coordinateX, new PriorityQueue<int[]>((x,y) -> x[0] == y[0] ? x[2] - y[2] : x[0] - y[0]));
            map.get(coordinateX).add(new int[]{coordinateY, node.val, step++});

            //987
            map.putIfAbsent(coordinateX, new PriorityQueue<int[]>((x,y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]));
            map.get(coordinateX).add(new int[]{coordinateY, node.val});
            
            dfs(node.left, coordinateX-1, coordinateY+1);
            dfs(node.right, coordinateX+1, coordinateY+1);
        }
    }
}
