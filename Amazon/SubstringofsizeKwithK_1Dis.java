import java.util.*;
public class SubstringofsizeKwithK_1Dis {

    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        //ans = SubstringOfSize("awaglknagawunagwkwagl", 4);
        //ans = lengthOfLongestSubstringKDistinct("awaglknagawunagwkwagl", 4);
        ans = lengthOfLongestSubstringKDistinct("wawaglknagagwunagkwkwagl", 4);

    }

    public static List<String> lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length() == 0) return new ArrayList<>();
        //if(s.length() * k == 0) return 0;
        List<String> ret = new ArrayList<>();
        int slow = 0;
        int fast = 0;
        char[] cA = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();

        while(fast < s.length())
        {
            if(map.size() == k-1)
            {
                if(Collections.max(map.values()) == 2)
                {
                    ret.add(s.substring(fast - k, fast));
                }
            }
            map.put(cA[fast], map.getOrDefault(cA[fast],0)+1);
            if(fast >= k)
            {
                map.put(cA[fast - k], map.getOrDefault(cA[fast - k],0)-1);
                if(map.get(cA[fast - k]) == 0)
                    map.remove(cA[fast - k]);

            }
            fast++;  
        }

        return ret;
    }
}
