class Solution {
    public String decodeAtIndex(String S, int K) {
        long sum = 0;
        for(int i = 0; i < S.length(); i++)
        {
            if(Character.isDigit(S.charAt(i)))
            {
                sum *= S.charAt(i) - '0';
            }
            else
                sum++;
        }
        int len = S.length();
        for(int i = len - 1; i >= 0; --i)
        {
            char c = S.charAt(i);
            K %= sum;
            if(K == 0 && !Character.isDigit(c))
                return c + "";
            if(Character.isDigit(c))
            {
                sum /= c - '0';
            }
            else
                sum--;
        }
        return "";
    }
}