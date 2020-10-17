https://aonecode.com/amazon-online-assessment-shopping-patterns

import java.util.*;

public class ShoppingPatterns {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        int[] from = new int[] { 1, 2, 2, 3, 4, 5, 4 };
        int[] to = new int[] { 2, 4, 5, 2, 5, 6, 6 };
        int ans = shoppingPatterns(6, 6, from, to);
        System.out.print("Hello");
    }

    public static int shoppingPatterns(int products_nodes, int producrs_edges, int[] products_from, int[] products_to) {
        HashMap<Integer, Set<Integer>> graph = BuildGraph(new HashMap<Integer, Set<Integer>>(), products_from,
                products_to);
        for (int key : graph.keySet()) {
            Set<Integer> set = new HashSet<Integer>();
            set.add(key);
            Connection(set, key, graph, key);

        }
        return min;
    }

    public static HashMap<Integer, Set<Integer>> BuildGraph(HashMap<Integer, Set<Integer>> graph, int[] from,
            int[] to) {
        for (int i = 0; i < from.length; i++) {
            int f = from[i];
            int t = to[i];
            graph.putIfAbsent(f, new HashSet<>());
            graph.putIfAbsent(t, new HashSet<>());
            graph.get(f).add(t);
            graph.get(t).add(f);
        }
        return graph;
    }

    public static void Connection(Set<Integer> set, int start, HashMap<Integer, Set<Integer>> graph, int current)
    { 
        if(set.size() == 3)
        {
            int countOutside = 0;
            for(int num : set)
            {
                for(int outNum : graph.get(num))
                {
                    if(!set.contains(outNum))
                        countOutside++;
                }
            }
            min = Math.min(min, countOutside);

            return;

        }
        Set<Integer> val = graph.get(current);
        for(int i : val)
        {
            if(!set.contains(i) && graph.get(i).contains(start))
            {
                set.add(i);
                Connection(set, start, graph, i);
                set.remove(i);
            }        
        }
    }
}
