class Solution {
    public int climbStairs(int n) {
        int[] list = new int[n + 1];
        int pre1 = 1;
        int pre2 = 1;
        for(int index = 2; index <= n; index++)
        {
            int sum = pre1 + pre2;
            pre1 = pre2;
            pre2 = sum;
        }
        return pre2;
    }
}
class Solution {
    public int climbStairs(int n) {
        if (n <= 0)
        return 0;
    int list[] = new int[n+1];
    list[0] = list[1] = 1;
    for (int i=2; i <= n; i++)
        list[i] = list[i-1] + list[i-2];
    return list[n];
    }
}