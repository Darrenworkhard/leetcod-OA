public class LC1680-ConcatenationOfBinaryNumbers {
    public int concatenatedBinary(int n) {
        if(n == 1) return 1;
        int modulo = 1000000007; 
        StringBuilder sb = new StringBuilder();
        int ret = 0;
        for(int i = 0; i <= n; i++)
        {
            String s = Integer.toBinaryString(i);
            for(int j = 0; j < s.length(); j++)
                ret = (ret * 2 + (s.charAt(j) - '0')) % modulo;
        }
        return ret;
    }
}
