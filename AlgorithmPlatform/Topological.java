package AlgorithmReview;

public class Topological {
    //Stack<Integer> stack = new Stack<Integer>();
    boolean isCycle = false;
    boolean[] visited = new boolean[0];  
    boolean[] visiting = new boolean[0];
    public boolean canFinish(int numCourses, int[][] req) {    
        visiting = new boolean[numCourses];
        visited = new boolean[numCourses];
        List<Integer>[] reqList = new ArrayList[numCourses];
        
        for(int[] i : req)
        {
            if(reqList[i[0]] == null)
                reqList[i[0]] = new ArrayList<Integer>();
            
            reqList[i[0]].add(i[1]);
        }

        for(int i = 0; i < numCourses; i++)
        {
            if(isCycle) break;
            
            if(!visited[i])
                dfs(req, i, reqList);
            
        }
        return !isCycle;
        
    }
    void dfs(int[][] req, int nodeNum, List<Integer>[] reqList)
    {
        visiting[nodeNum] = true;
        List<Integer> list = reqList[nodeNum];
        if(list != null)
            for(int i : list)
            {
                 if(visiting[i])
                    {
                        isCycle = true;
                        return;
                    }
                    else
                        dfs(req, i, reqList);
            }
        visited[nodeNum] = true;
        visiting[nodeNum] = false;
        
    }
}
