public class LC1663-SmallestNumericValue {
    class Solution {
        public String getSmallestString(int n, int k) {
            //StringBuilder sb = new StringBuilder(); TLE
            char[] cA = new char[27];
            for(int i = 1; i < 27; i++)
            {
                cA[i] = (char)(i+'a'-1);
            }
            char[] ans = new char[n];
            int index = n-1;
            for(int i = 26; i > 0; i--)
            {
                while(k - n + 1 >= i && n > 0)
                {      
                    //sb.insert(0, cA[i]);TLE
                    ans[index--] = cA[i];
                    k = k - i;
                    n--;
                }
               
                if(n == 0)
                    break;
            }
            return new String(ans); //sb.toString(); TLE
        }
    }
}
