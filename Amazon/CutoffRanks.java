import java.util.*;

public class CutoffRanks {

    public static void main(String[] args) {
        int[] scores  = new int[] {100,50,50,25};
        int ans = cutOffRank(3, 4, scores);

    }
    //Accept
    public static int cutOffRank(int cutOffRank, int num, int[] scores) {
        if(cutOffRank == 0) return 0;
        if(num <= cutOffRank) return num;
        int[] sort = new int[101];
        for(int i : scores)
        {
            sort[i] += 1;
        }
        int count = 0;
        for(int i = 100; i >= 0; i--)
        {
            count += sort[i];
            if(count >= cutOffRank)
                return count;
        }
        
        return count;
    }

    //TLE
    public static int cutOffRank1(int cutOffRank, int num, int[] scores) {
        if(cutOffRank == 0) return 0;
        if(num <= cutOffRank) return num;
        
        PriorityQueue<Integer> q = new PriorityQueue<>((x,y) -> y - x);
        for(int i = 0; i < scores.length; i++)
        {
            q.add(scores[i]);
        }
        int count = 1;
        int last = q.poll();
        while(!q.isEmpty())
        {
            if(q.peek() != last)
            {
                last = q.peek();
                if(count >= cutOffRank)
                {
                    break;
                }
            }
            count++;
            q.poll();
        }
       
        return count;
    }
}
