package Good.Medium;
import java.util.*;

public class LC_820_ShortEncodingOfWords {
    //T:O(W) w is the length of words[i];
    //S:O(W) w is the space used by the trie;
    class Trie {
        Trie[] children;
        int count;
        Trie()
        {
            children = new Trie[26];
            count = 0;
        }
        Trie get(char c)
        {
            if(children[c-'a'] == null)
            {
                count++;
                children[c-'a'] = new Trie();
            }
            return children[c-'a'];
        }
    }
    public int minimumLengthEncoding_S1(String[] words) {
        HashMap<Trie, Integer> map = new HashMap<>();
        Trie trie = new Trie();
        for(int i = 0; i < words.length; i++)
        {
            Trie cur = trie;
            for(int j = words[i].length()-1; j >= 0; j--)
            {
                cur = cur.get(words[i].charAt(j));
            }
            map.put(cur, i);
        }
        int sum = 0;
        for(Trie node : map.keySet())
        {
            if(node.count == 0)
            {
                sum += words[map.get(node)].length()+1;
            }
        }
        return sum;
    }

    //S2
    //T:O(W^2) w is the length of words[i];
    //S:O(W) w is the space used by the trie;
    public int minimumLengthEncoding_S2(String[] words) {
        HashSet<String> set = new HashSet<>(List.of(words));
        for(int i = 0; i < words.length; i++)
        {
            for(int j = 1; j < words[i].length(); j++)
            {
                set.remove(words[i].substring(j));
            }
        }
        int sum = 0;
        for(String s : set)
        {
            sum += s.length()+1;
        }
        return sum;
    }
}
