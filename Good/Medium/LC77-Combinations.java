class Solution {
    public List<List<Integer>> combine(int n, int k) {
       List<List<Integer>> ans = new ArrayList<List<Integer>>();
       if(n == 0 && k == 0) return ans;
       
       dfs(n, k, 1, new ArrayList<Integer>(), ans);
       
       return ans;
   }
   
   void dfs(int n, int k, int deep, List<Integer> subList, List<List<Integer>> ans)
   {
       if(subList.size() == k)
       {
           ans.add(new ArrayList<Integer>(subList)); 
           return;
       }
       else
       {
           for(int i = deep; i <= n; i++)
           {
               subList.add(i);
               dfs(n, k, i+1, subList, ans);
               subList.remove(subList.size() - 1);
           }
       }
   }
}