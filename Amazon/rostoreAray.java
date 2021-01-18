import java.util.*;

public class rostoreAray {
    static HashMap<Integer, List<Integer>> map =  new HashMap<>();
    static HashSet<Integer> set = new LinkedHashSet<>();

    public static void main(String[] args)
    {
        int[][] input= new int[1][1];//{30,95,4,8,19,89};
        //先建立geaph
        BuildGraph(input);

        //找出只有對應一個的節點
        for(int key : map.keySet())
        {
            List<Integer> list = map.get(key);
            if(list.size() == 1)
            {
                set.add(key);
                //搜尋所有節點
                connection(key);
                break;
            }

        }

        //回傳
        int[] ret = new int[set.size()];
        int index = 0;
        for(int i : set)
        {
            ret[index++] = i;
        }

        System.out.print(ret);
    }
    //1.建立geaph function
    static void BuildGraph(int[][] input)
    {
        for(int[] i : input)
        {
            map.putIfAbsent(i[0], new ArrayList<>());
            map.putIfAbsent(i[1], new ArrayList<>());
            map.get(i[0]).add(i[1]);
            map.get(i[1]).add(i[0]);
        }
    }
    //2.找出所有節點 function
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
