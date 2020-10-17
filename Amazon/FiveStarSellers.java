import java.util.*;
//Solution1
public class Solution {
 static int total = 0;
	 	static boolean findans = false;
	    //PriorityQueue<int[]> pQ = new PriorityQueue<>((x,y) -> x[0] / x[1] == y[0] / y[1] ? x[1] < y[1] ? -1 : 1 : x[0] / x[1] - y[0] / y[1]);
	    //HashMap<>
	    public static int fiveStarReviews(int[][] productRatings, int ratingsThreshold) {
	        double curent = 0;
	        for(int[] i : productRatings)
	        {
	            double percantage = (double)i[0] / (double)i[1];
	            curent += percantage;
	        }
	        curent = curent / productRatings.length * 100;

	        dfs(productRatings, ratingsThreshold, curent);
	        return total;
	    }
	    static void dfs(int[][] productRatings, int ratingsThreshold, double current)
	    {
	        if(ratingsThreshold <= current)
	        {
	            findans = true;
	            return;
	        }
	        total++;
	        int maxIndex = 0;
	        double addMaxPer = current;
	        for(int i = 0; i < productRatings.length; i++)
	        {
	            int[] product = productRatings[i];
	            double original = (double)product[0] / (double)product[1] * 100;
	            int[] val = new int[]{product[0], product[1]};
	            val[0] += 1;
	            val[1] += 1;
	            double percantage = (double)val[0] / (double)val[1] * 100;
	            double newPercantage = current + (percantage - original) / productRatings.length;
	            if(addMaxPer < newPercantage)
	            {
	                maxIndex = i;
	                addMaxPer = newPercantage;
	            }
	        }
	        productRatings[maxIndex][0] += 1;
	        productRatings[maxIndex][1] += 1;
	        
	        current = addMaxPer;
	        dfs(productRatings, ratingsThreshold, current);
	        
	        return;
	            
	    }
}
