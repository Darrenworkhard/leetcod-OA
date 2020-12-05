class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int[] mem = new int[n+1];
        for(int i = 1; i <= n; i++)
        {
            if(n % i == 0)
            {
                list.add(i);
            }
            if(list.size() == k)
                return i;
            // if(mem[i] != 0)
            //     list.add(mem[i]);
            // else if(n % i == 0)
            // {
            //     list.add(i);
            //     mem[n / i] = i;
            // }
                
        }
        return -1;
       
    }
}