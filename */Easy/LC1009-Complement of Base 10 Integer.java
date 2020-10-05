//Solution 1
class Solution {
    public int bitwiseComplement(int N) {
        if(N == 0) return 1;
        int x = ~N;
        String s = Integer.toBinaryString(N);
        int index = s.length() - 1;
        while(index > 0)
        {
            if(s.charAt(index) == '1')
                break;
            
            index--;
        }
        String ans = Integer.toBinaryString(x);
   
        return Integer.parseInt(ans.substring(ans.length() - s.length()),2);
    }
}
//Solution2
class Solution {
    public int bitwiseComplement(int number) {
        String binaryString = Integer.toBinaryString(number);
        char[] reverseChars = new char[binaryString.length()];
        char[] charArray = binaryString.toCharArray();
        for (int index = 0; index < charArray.length; index++) {
            if (charArray[index] == '0') {
                reverseChars[index] = '1';
            } else {
                reverseChars[index] = '0';
            }
        }
        return Integer.parseInt(new String(reverseChars), 2);
    }
}
