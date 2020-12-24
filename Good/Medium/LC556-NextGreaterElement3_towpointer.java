public class LC556_NextGreaterElement3_towpointer {
    //find the fist and second small number to change
    //Ex : 12737891
    public int nextGreaterElement(int n) {
        if(n == 0) return -1;
        String s = String.valueOf(n);
        char[] c = s.toCharArray();
        int i = s.length() - 2;
        //get first not accending number : 127(3)7891
        while(i >= 0 && c[i] >= c[i+1]) i--;   
        if(i < 0) return -1;
        else
        {
            //find the second number lower than first number
            //127(3)789(1)
            int j = s.length() - 1;
            while(j >= 0 && c[j] <= c[i]) j--;
            //after swap would like 127(1)789(3)
            swap(i, j, c);
        }
        //order by after chage number
        //127(1)(3789)
        reverse(i + 1, s.length() - 1 , c);

        long ans = 0;
        for(int k = 0; k < c.length; k++)
        {
            ans = ans * 10 + (c[k] - '0');
        }
        //make sure not over than int max;
        return ans > Integer.MAX_VALUE ? -1 : (int)ans ;
    }
    void swap(int i, int j, char[] c)
    {
        char temp = c[j];
        c[j] = c[i];
        c[i] = temp;
    }
    void reverse(int i, int j, char[] c)
    {
        while(i < j)
        {
            swap(i, j, c);
            i++;
            j--;
        }
    }
}
