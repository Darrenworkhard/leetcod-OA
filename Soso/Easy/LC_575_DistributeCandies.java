package Soso.Easy;

public class LC_575_DistributeCandies {
    public int distributeCandies(int[] candyType) {
        
        Set<Integer> set = new HashSet<>();
        for(int type : candyType)
        {
            set.add(type);
        }
        int countType = set.size();
        
        return Math.min(countType, candyType.length/2);
    }
}
