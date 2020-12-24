// timeO(N)
//BFS
class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> used = new HashSet<>();
        q.add(start);
        while(!q.isEmpty())
        {
            int cur = q.poll();
            
            if(arr[cur] == 0)
                return true;
            //if(used.contains(cur))
                //continue;
            if(!used.contains(cur))
            {
                if(cur + arr[cur] < arr.length)
                    q.add(cur + arr[cur]);
                if(cur - arr[cur] >= 0)
                    q.add(cur - arr[cur]);
                used.add(cur);
            }
        }
        return false;
    }
}
//Dfs
class Solution {
    boolean find = false;
    public boolean canReach(int[] arr, int start) {
        Set<Integer> used = new HashSet<>();
        dfs(arr, start, used);       
        return find;
    }
    void dfs(int[] arr, int cur, Set<Integer> used)
    {
        if(cur >= arr.length || cur < 0 || used.contains(cur))
            return;
        if(arr[cur] == 0)
        {
            find = true;
            return;
        }
       
        if(!find)
        {
            used.add(cur);
            dfs(arr, cur + arr[cur], used);
            dfs(arr, cur - arr[cur], used);
        }  
    }
}