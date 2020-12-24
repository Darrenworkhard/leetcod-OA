import java.util.*;

public class rostoreAray {
    static HashMap<Integer, List<Integer>> map =  new HashMap<>();

    static HashSet<Integer> set = new LinkedHashSet<>();

    public static void main(String[] args)
    {

        int[][] averageUtil = new int[1][1];//{30,95,4,8,19,89};
        BuildGraph(averageUtil);

        for(int key : map.keySet())
        {
            List<Integer> list = map.get(key);
            if(list.size() == 1)
            {
                set.add(key);
                connection(key);
                break;
            }

        }

        int[] ret = new int[set.size()];
        int index = 0;
        for(int i : set)
        {
            ret[index++] = i;
        }

        System.out.print(ret);
    }

    static void BuildGraph(int[][] input)
    {
        for(int[] i : input)
        {
            map.putIfAbsent(i[0], new ArrayList<>());
            map.putIfAbsent(i[1], new ArrayList<>());
            map.get(i[0]).add(i[1]);
            map.get(i[0]).add(i[1]);
        }
    }

    static void connection(int current)
    {
        if(set.size() == map.size())
            return;

        List<Integer> list = map.get(current);

        for(int i : list)
        {
            if(!set.contains(i))
            {
                set.add(i);
                connection(i);
            }
        }
    }


}
