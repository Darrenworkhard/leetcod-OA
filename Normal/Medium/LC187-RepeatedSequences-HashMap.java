//Solution1 99%
public class Solution {
    
    private final static int[] map = new int[128];
    
    static {
        map['A'] = 0; map['C'] = 1; map['G'] = 2; map['T'] = 3;
    }
    
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 10) return ans;
        char[] chars = s.toCharArray();
        boolean[] hashCodeMap = new boolean[1048576], added = new boolean[1048576];
        
        int hashCode = 0, i = 0;
        for (; i < 10; i++) {
            hashCode = (hashCode << 2) + map[chars[i]];
        }
        hashCodeMap[hashCode] = true;
        for (; i < chars.length; i++) {
             hashCode = ((hashCode << 2) & 0xFFFFF) + map[chars[i]];
            
            
            if (hashCodeMap[hashCode] && !added[hashCode]) {
                ans.add(new String(chars,i-9,10));
                added[hashCode] = true;
            }
            hashCodeMap[hashCode] = true;
        }
        
        return ans;
    }
    
    //This is a sort of queue ..where A is 00, C-01, G-10, T-11
    //we first ..start adding the values to the number..by bit mask and bit shift
    //when we reach 10 length (which is same as 20 bits in binary)... we need to check if we have seen this earlier
    //for next incoming character (11th position).. we will need to remove the character at the beginning.. 
    // to keep the length of the queue to 10
    //to drop the first character.. we did value &= 0xfffff (1048575  or binary 11111111111111111111) ..which is 20 set bits
    //the first character is represented by 2 bits...so to drop the first 2 bits from 22 bits number...we used above logic
    //Eg: 11101011111111111011 -- 20 bits (10 characters)
    //    1110101111111111101100 -- 22 bits (11 characters)
    //    1110101111111111101100  -- do And operation
    //  &   11111111111111111111  -- with 20 set bits
    //Ans:  10101111111111101100  -- First 2 bits are dropped from 22 bit number
    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> result = new ArrayList<>();
        Set<Integer> word = new HashSet<>();
        Set<Integer> secondWord = new HashSet<>();
        int[] map = new int[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            value <<= 2;
            value |= map[s.charAt(i) - 'A'];
            System.out.println(Integer.toBinaryString(value));
            value &= 0xfffff;//1048575
            System.out.println(Integer.toBinaryString(value));
            if (i < 9) {
                continue;
            }
            if (!word.add(value) && secondWord.add(value)) {
                result.add(s.substring(i - 9, i + 1));
            }
        }
        return result;
    }
}

//solution2 80%
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() <= 9) return new ArrayList<>();
        Set<String> set = new HashSet<>();
        int i = 0;
        int j = 9;
        List<String> ans = new ArrayList<>();
        while(j < s.length())
        {
            String newS = s.substring(i, j+1);
            if(!set.contains(newS) || ans.contains(newS))
                set.add(newS);
            else
            {
                ans.add(newS);
            }
            i++;
            j++;
        }
        return ans;
    }
}
