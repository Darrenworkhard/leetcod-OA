import java.util.*;
//https://www.youtube.com/watch?v=7Xw4XVRF1es&t=2s
//Solution1
//PriorityQueue O(log(N))
//Time O()
//Space O(N)
public class FiveStarSellers {
	static int total = 0;
			static boolean findans = false;
			public static void main(String[] args) {
			   int[][] from = {{35, 35},{3, 2},{3, 6},{35, 335},{3, 22},{3, 36},{35, 235},{0, 2},{6, 6},{35, 35},{3, 2},{3, 6},{35, 335},{3, 22},{3, 36},{35, 235},{0, 2},{6, 6}};
			   int ans = fiveStarReviews(from,99);
		   }
   
		   public static int fiveStarReviews(List<List<Integer>> productRatings, int ratingsThreshold) 
		   {
			   int count = 0;

			   PriorityQueue<List<Integer>> pq = new PriorityQueue((l1, l2) -> diff(l2) - diff(l1));

			   for(List<Integer> rating : productRatings)
			   {
				   pq.add(rating);
			   }

			   double current = 0;
			   for(List<Integer> rating : productRatings)
			   {
					current += (double)rating.get(0) / (double)rating.get(1);
			   }
			   current = current / productRatings.size() * 100;

			   while(current < ratingsThreshold)
			   {

					count++;

					List<Integer> topRating = pq.poll();

					List<Integer> newRating = Arrays.asList(topRating.get(0) + 1, topRating.get(1) + 1);

					current += (newRating.get(0) / newRating.get(1)) - (topRating.get(0) / topRating.get(1));

					pq.add(newRating);
			   }

			   return count;
		
		   }
		   public int diff(List<Integer> list)
		   {
			   double crrentRating = 100.0 * (list.get(0) / list.get(1));
			   double newRating = 100.0 * (list.get(0)+1 / list.get(1)+1);

			   return (int)(newRating - crrentRating);
		   }
		   
   
}
//Solution2
public class FiveStarSellers_1 {
 static int total = 0;
		 static boolean findans = false;
		 public static void main(String[] args) {
			int[][] from = {{35, 35},{3, 2},{3, 6},{35, 335},{3, 22},{3, 36},{35, 235},{0, 2},{6, 6},{35, 35},{3, 2},{3, 6},{35, 335},{3, 22},{3, 36},{35, 235},{0, 2},{6, 6}};
			int ans = fiveStarReviews(from,99);
		}

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

