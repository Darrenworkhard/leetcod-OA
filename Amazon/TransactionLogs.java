import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Collections;
//Time O(n)
//Space O(n)
public class TransactionLogs {

    public static void main(String[] args) {
        String[] from = new String[] {"88 99 200", "88 99 300", "99 32 100", "12 12 15"};
        int[] scores = new int[] {1,2,3,4,5};
         
        PriorityQueue<Integer> q = new PriorityQueue(scores);
        for(int i = 0; i < nums.length; i++)
        {
            q.add(scores[i]);
        }
        String[] ans = processLogFile(from, 2);
        System.out.print("Hello");
    }

    public static String[] processLogFile(String[] logs, int threshold) {
        if(logs.length == 0) return new String[0];
        Map<String, Integer> map = new HashMap<>(); 
        for(String s : logs)
        {
            String[] sA = s.split(" ");
            if(!sA[0].equals(sA[1]))
            {
                map.put(sA[0],map.getOrDefault(sA[0],0)+1);
                map.put(sA[1],map.getOrDefault(sA[1],0)+1);
            }
            else
            {
                map.put(sA[0],map.getOrDefault(sA[0],0)+1);
            }   
        }
        PriorityQueue<String> q = new PriorityQueue<>((x,y) -> {
            return x.compareTo(y);
            });
        for(String s : map.keySet())
        {
            if(map.get(s) >= threshold)
            {
                q.add(s);
            }
        }
        String[] ans = new String[q.size()];
        for(int i = 0; i < ans.length; i++)
        {
            ans[i] = q.poll();
        }
        return ans;
    }
}
