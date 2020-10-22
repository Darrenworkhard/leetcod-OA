//https://aonecode.com/amazon-online-assessment-nearest-cities
import java.util.*;
import java.io.*;
import java.lang.*;

public class NearestCities {
    public String[] findNearestCities(int numOfCities,
                                 String[] cities,
                                 int[] xCoordinates,
                                 int[] yCoordinates,
                                 int numOfQueries,
                                 String[] queries) {
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < cities.length; i++)
        {
            PriorityQueue<String> q = new PriorityQueue<>();
            int mindis = Integer.MAX_VALUE;
            List<Integer> minindex = new ArrayList<>();
            for(int x = 0; x < xCoordinates.length; x++)
            {
                if(x != i && xCoordinates[x] == xCoordinates[i])
                {
                    int dis = Math.abs(yCoordinates[x] - yCoordinates[i]);
                    if(mindis == dis)
                    {
                        minindex.add(x);
                    }
                    else if(mindis > dis)
                    {
                        minindex = new ArrayList<>();
                        mindis = dis;
                        minindex.add(x);
                    }
                }
            }
            for(int y = 0; y < yCoordinates.length; y++)
            {
                if(y != i && yCoordinates[y] == yCoordinates[i])
                {
                    int dis = Math.abs(xCoordinates[y] - xCoordinates[i]);
                    if(mindis == dis)
                    {
                        minindex.add(y);
                    }
                    else if(mindis > dis)
                    {
                        minindex = new ArrayList<>();
                        mindis = dis;
                        minindex.add(y);
                    }
                }
            }
            
            for(int index : minindex)
            {
                q.add(cities[index]);
            }
            if(!q.isEmpty())
            {
                map.put(cities[i], q.poll());
            }
        }
        String[] ans = new String[numOfQueries];
        for(int i = 0; i < queries.length; i++)
        {
            if(map.containsKey(queries[i]))
                ans[i] = map.get(queries[i]);
        }
        return ans;
    }
}
