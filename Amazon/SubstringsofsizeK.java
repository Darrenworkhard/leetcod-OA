import java.util.*;

public class SubstringsofsizeK{
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        //ans = SubstringOfSize("awaglknagawunagwkwagl", 4);
        ans = SubstringOfSize("awaglk", 4);

    }
    public static List<String> SubstringOfSize(String s, int k)
    {
        if(s.length() == 0 || k == 0) return new ArrayList<String>();
        Set<String> ans = new LinkedHashSet<>(); 
        Set<Character> set = new HashSet<>();
        char[] cA = s.toCharArray();
        int i = 0;
        int j = 0;
        while(j < cA.length)
        {
            if(set.contains(cA[j]))
            {
                set.remove(cA[i]);
                i++;
            }
            else if(j - i == k -1)
            {
                ans.add(s.substring(i, j+1));
                set.remove(cA[i]);
                i++;
            }
            else if(j < k + i -1)
            {
                set.add(cA[j]);
                j++;

            }
        }
        return new ArrayList<>(ans);

    }
}
