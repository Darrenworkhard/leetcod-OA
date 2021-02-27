package Good.Medium;
import java.util.*;
class LC856_ScoreOfParentheses {
    //Time Complexity: O(N^2)O(N2), where NN is the length of S. An example worst case is (((((((....))))))).
    public int scoreOfParentheses_S1(String s) {
        return dfs(s, 0, s.length());
    }
    int dfs(String s, int l, int r)
    {
        int ans = 0;
        if(s.length() == 0)
            return 0;
        int bal = 0;
        for(int i = l; i < r; i++)
        {
            bal += s.charAt(i) == '(' ? 1 : -1;
            if(bal == 0)
            {
                if(i - l == 1)
                    ans++;
                else
                    ans += 2 * dfs(s, l+1, i);    
                //ex: (()())
                l = i+1;
            }
            
        }
        return ans;
    }

    //O(N)
    public int scoreOfParentheses_S2(String s) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(0);
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
                dq.addFirst(0);
            else
            {
                int cur = dq.pollFirst();
                int pre = dq.pollFirst();
                dq.addFirst(pre + Math.max(cur * 2, 1));
            }
        }
        return dq.pollFirst();
    }
}