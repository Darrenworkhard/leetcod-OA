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
			   //int[][] from ={{4, 4},{1, 2},{3, 6}};
			   List<List<Integer>> productRating = new ArrayList<>();
				for(int[] s : from)
				{
					List<Integer> t = new ArrayList<>();
					for(int i : s)
					{
						t.add(i);
					}
					productRating.add(t);
				}
			   int ans = fiveStarReviews(productRating,99);

			   System.out.println(ans);
		   }
		   public static int solution(List<List<Integer>> rating, int threshold){
			PriorityQueue<List<Double>> q = new PriorityQueue<List<Double>>(rating.size(), (a,b)->{
				double i = (a.get(0)+1) / (a.get(1)+1) - a.get(0) / a.get(1) ;
				double j = (b.get(0)+1)  / (b.get(1)+1)  - b.get(0) / b.get(1) ;
				if(j-i > 0.0){
					return 1;
				}else if(j-i < 0.0){
					return -1;
				}
				return 0;
			 });
	
			 double sum = 0;
			 
			 for(List<Integer> r: rating){
				 List<Double> d = new ArrayList<>();
				 d.add((double) r.get(0));
				 d.add((double) r.get(1));
				 q.add(d);
				 double dd = r.get(0) *1.0 / r.get(1) * 1.0;
				 sum+= dd;
				 
			 }
			 
			 int count = 0;
			 int total = rating.size();
			 while( sum / total * 100 < threshold ){
				// System.out.println( q);
				List<Double> l = q.poll();
				double rate = l.get(0);
				double trate = l.get(1);
				sum -= rate  / trate ;
				sum += (rate+1)  / (trate+1);
				//System.out.println(sum);
				l.set(0, rate+1);
				l.set(1, trate+1);
				q.add(l);
				count++;
			 }
			 return count;
		}
		   public static int fiveStarReviews(List<List<Integer>> productRatings, int ratingsThreshold) 
		   {
			   int count = 0;

			//    PriorityQueue<List<Double>> pq = new PriorityQueue<List<Double>>((a,b)->{
			// 		double i = (a.get(0)+1) / (a.get(1)+1) - a.get(0) / a.get(1) ;
			// 		double j = (b.get(0)+1)  / (b.get(1)+1)  - b.get(0) / b.get(1) ;
			// 		if(j-i > 0.0){
			// 			return 1;
			// 		}else if(j-i < 0.0){
			// 			return -1;
			// 		}
			// 		return 0;
			//  });

			PriorityQueue<List<Double>> pq = new PriorityQueue<List<Double>>((l1, l2) -> {
				double crrentRating = (l1.get(0)+1) / (l1.get(1)+1) - (l1.get(0)) / (l1.get(1));
			    double newRating = (l2.get(0)+1) / (l2.get(1)+1) - (l2.get(0)) / (l2.get(1));

				if(newRating-crrentRating > 0.0){
					return 1;
				}else if(newRating-crrentRating < 0.0){
					return -1;
				}
				return 0;
			});

			   for(List<Integer> rating : productRatings)
			   {
					List<Double> l = new ArrayList<>();
				   for(int i : rating)
				   {
					   l.add((double)i);
				   }
				   pq.add(l);
			   }

			   double current = 0;
			   for(List<Integer> rating : productRatings)
			   {
					current += (double)rating.get(0) / (double)rating.get(1);
			   }
			   //current = current / productRatings.size() * 100;

			   while(current / productRatings.size() * 100 < ratingsThreshold)
			   {

					count++;

					List<Double> topRating = pq.poll();

					List<Double> newRating = Arrays.asList(topRating.get(0) + 1, topRating.get(1) + 1);

					current -= topRating.get(0) / topRating.get(1); 
					current += newRating.get(0) / newRating.get(1);

					pq.add(newRating);
			   }

			   return count;
		
		   }
		   public static int diff(List<Double> list)
		   {
			    // double crrentRating = 100.0 * list.get(0) / list.get(1);
			    // double newRating = 100.0 * (list.get(0)+1) / (list.get(1)+1);

				// if(newRating-crrentRating > 0.0){
				// 	return 1;
				// }else if(newRating-crrentRating < 0.0){
				// 	return -1;
				// }
				// return 0;
			   //return (int)(newRating - crrentRating);
		   }
		   
   
}
//Solution2
// public class FiveStarSellers {
//  		static int total = 0;
// 		 static boolean findans = false;
// 		 public static void main(String[] args) {
// 			//int[][] from = {{35, 35},{3, 2},{3, 6},{35, 335},{3, 22},{3, 36},{35, 235},{0, 2},{6, 6},{35, 35},{3, 2},{3, 6},{35, 335},{3, 22},{3, 36},{35, 235},{0, 2},{6, 6}};
// 			int[][] from ={{4, 4},{1, 2},{3, 6}};
// 			int ans = fiveStarReviews(from,90);
// 			System.out.println(ans);
// 		}

// 		//no static for online assessment
// 	    public static int fiveStarReviews(int[][] productRatings, int ratingsThreshold) {
// 	        double curent = 0;
// 	        for(int[] i : productRatings)
// 	        {
// 	            double percantage = (double)i[0] / (double)i[1];
// 	            curent += percantage;
// 	        }
// 	        curent = curent / productRatings.length * 100;


// 			FiveStarSellers t = new FiveStarSellers();
// 	        t.dfs(productRatings, ratingsThreshold, curent);
// 	        return total;
// 	    }
// 		void dfs(int[][] productRatings, int ratingsThreshold, double current)
// 	    {
// 	        if(ratingsThreshold <= current)
// 	        {
// 	            findans = true;
// 	            return;
// 	        }
// 	        total++;
// 	        int maxIndex = 0;
// 	        double addMaxPer = current;
// 	        for(int i = 0; i < productRatings.length; i++)
// 	        {
// 	            int[] product = productRatings[i];
// 	            double original = (double)product[0] / (double)product[1] * 100;
// 	            int[] val = new int[]{product[0], product[1]};
// 	            val[0] += 1;
// 	            val[1] += 1;
// 	            double percantage = (double)val[0] / (double)val[1] * 100;
// 	            double newPercantage = current + (percantage - original) / productRatings.length;
// 	            if(addMaxPer < newPercantage)
// 	            {
// 	                maxIndex = i;
// 					addMaxPer = newPercantage;
					
// 	            }
// 	        }
// 	        productRatings[maxIndex][0] += 1;
// 	        productRatings[maxIndex][1] += 1;
	        
// 			current = addMaxPer;
// 			System.out.println(current);
// 	        dfs(productRatings, ratingsThreshold, current);
	        
// 	        return;
	            
// 		}
// 	}

