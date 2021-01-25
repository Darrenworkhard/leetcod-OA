package Normal.Medium;

public class LC1645-CountSortedVowel-DP {

    //Math O(1)
    public int countVowelStrings(int n) {
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
    }
    //DP O(5N = N)
    public int countVowelStringsS1(int n) {
        if(n == 1) return 5;

        int[][] arr = new int[n+1][5];

        for(int i = 0; i <= n; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(j == 0 || i == 0)
                    arr[i][j] = 1;
                else
                    arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }

        return arr[n][4];
    }


    public int countVowelStrings2(int n) {
        if(n == 1) return 5;
        if(n == 2) return 15;
        
        int[] arr = new int[5];
        Arrays.fill(arr, 1);
        for(int i = 1; i < n; i++)
        {
            for(int j = 1; j < 5; j++)
            {
                arr[j] += arr[j-1];
            }
        }
        
        int ret = 0;
        for(int num : arr)
        {
            ret += num;
        }
        return ret;
    }
}
