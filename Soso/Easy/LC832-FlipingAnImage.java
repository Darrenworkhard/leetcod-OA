class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        //flip
        for(int i = 0; i < A.length; i++)
        {
            A[i] = flip(A[i]);
        }
        return A;
    }
    int[] flip(int[] input)
    {
        int i = 0;
        int j = input.length-1;
        while(i <= j)
        {
            int temp = input[i];
            input[i] = input[j] == 0 ? 1 : 0;
            input[j] = temp == 0 ? 1 : 0;
            i++;
            j--;
        }
        return input;
    }
}