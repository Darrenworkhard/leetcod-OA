class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, candidates, target, new ArrayList<Integer>(), 0, ans);
        
        return ans;
    }
    
    void dfs(int start, int[] candidates, int target, List<Integer> subList, int cal, List<List<Integer>> ans)
    {
        if(cal > target)
            return;
        else if(cal == target)
            ans.add(new ArrayList<Integer>(subList));
        else
        {
            for(int i = start; i < candidates.length; i++)
            {
                
                subList.add(candidates[i]);                
                dfs(i, candidates, target, subList, cal + candidates[i], ans);
                subList.remove(subList.size() - 1);
            }
        }
    }
}
