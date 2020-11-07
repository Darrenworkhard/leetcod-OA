class Solution {
    public int maxPower(String s) {
        char cur = s.charAt(0);
        int ans = 1;
        int count = 1;
        for(int i = 1; i < s.length(); i++)
        {
            if(s.charAt(i) == cur)
                count++;
            else
            {
                count = 1;
                cur = s.charAt(i);
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}