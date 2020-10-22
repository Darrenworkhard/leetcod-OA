import java.util.*;
import java.io.*;
import java.lang.*;

public class LRUCacheMisses {
    //Accept
    public int lruCacheMisses(int num, List<Integer> pages, int maxCacheSize) {
        if(num == 0) return 0;
        HashSet<Integer> linkSet = new LinkedHashSet<>();
        int miss = 0;
        for(int i : pages)
        {
            if(linkSet.contains(i))
            {
                linkSet.remove(i);
                linkSet.add(i);
            }
            else
            {
                linkSet.add(i);
                miss++;
            }
            if(linkSet.size() > maxCacheSize)
            {
                for(int number : linkSet)
                {
                    linkSet.remove(number);
                    break;
                }
            }
        }
        return miss;
    }

    //TLE
    public class Solution {
        public int lruCacheMisses(int num, List<Integer> pages, int maxCacheSize) {
            if(num == 0) return 0;
            Queue<Integer> q = new LinkedList<>();
            HashSet<Integer> s = new HashSet<>();
            int miss = 0;
            for(int i : pages)
            {
                if(s.contains(i))
                {
                    Queue<Integer> newQ = new LinkedList<>();
                    while(!q.isEmpty())
                    {
                        if(q.peek() != i)
                        {
                            newQ.add(q.poll());
                        }
                    }
                    newQ.add(i);
                    q = newQ;
                }
                else
                {
                    s.add(i);
                    q.add(i);
                    miss++;
                }
                if(q.size() > maxCacheSize)
                {
                    int remove = q.poll();
                    s.remove(remove);
                }
            }
            return miss;
        }
    }
}
