package Normal.Medium;
import java.util.*;



//Time Complexity: O(2N∗N)O(2^{N} * N)O(2N∗N), where NNN is the length of S. This reflects the cost of writing the answer.
//Space Complexity: O(2N∗N)O(2^N * N)O(2N∗N).

public class LC784_LetterCasePermutation {
    List<String> ret = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        if(S.length() == 0) return ret;
        List<String> list = new LinkedList<>();
        permHelper( S.toCharArray(), 0, list);
        return ret;
    }
    //S1
    private void permHelper( char[] strArr, int pos, List<String> list ){
        if( pos == strArr.length ){
            ret.add(new String(strArr));
            return;
        }

        if( strArr[pos] >='0' && strArr[pos] <= '9' ){
            permHelper( strArr, pos + 1, list);
            return;
        }

        strArr[pos] = Character.toUpperCase(strArr[pos]);
        permHelper( strArr, pos + 1, list);

        strArr[pos] = Character.toLowerCase(strArr[pos]);
        permHelper( strArr, pos + 1, list);
        
    }
    //S2
    void permutation(String s, StringBuilder sb, int index)
    {
        if(sb.length() == s.length())
        {
            ret.add(sb.toString());
            return;
        }
        for(int i = index; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                sb.append(c);
                permutation(s, sb, i+1);
                sb.delete(sb.length()-1, sb.length());
            }
            else
            {
                sb.append(Character.toLowerCase(c));
                permutation(s, sb, i+1);
                sb.delete(sb.length()-1, sb.length());
                sb.append(Character.toUpperCase(c));
                permutation(s, sb, i+1);
                sb.delete(sb.length()-1, sb.length());
            } 
        }
    }
}
