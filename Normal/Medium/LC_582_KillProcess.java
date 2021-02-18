package Normal.Medium;

import java.util.*;
public class LC_582_KillProcess {
    List<Integer> ret = new ArrayList<>();
    HashMap<Integer, List<Integer>> parents = new HashMap<>();
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        dfs(pid, ppid, kill);
        return ret;
    }

    //Time complexity : O(n)
    //Space complexity : O(n)
    void dfs(List<Integer> pid, List<Integer> ppid, int kill)
    {
        ret.add(kill);
        if(!parents.containsKey(kill))
            return;
        List<Integer> lists = parents.get(kill);
        if(lists == null) return;
        for(int i : lists)
        {
            int child = pid.get(i);
            dfs(pid, ppid, child); 
        }
        
    }

    //TLE
    //Time complexity : O(n^n)
    //Space complexity : O(n)
    void dfs_TLE(List<Integer> pid, List<Integer> ppid, int kill)
    {
        ret.add(kill);
        for(int i = 0; i < ppid.size(); i++)
        {
            if(ppid.get(i) == kill)
            {
                dfs(pid, ppid, pid.get(i));    
            }
        }
    }
}
