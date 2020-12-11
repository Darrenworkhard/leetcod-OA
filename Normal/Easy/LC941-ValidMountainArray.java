class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        int topIndex1 = -1;
        int topIndex2 = -1;
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] == arr[i-1]) return false;
            else if(arr[i] < arr[i-1])
            {
                topIndex1 = i-1;
                break;
            }      
        }
        for(int i = arr.length-2; i >= 0; i--)
        {
            if(arr[i] == arr[i+1]) return false;       
            else if(arr[i] < arr[i+1])
            {
                topIndex2 = i+1;
                break;
            }
                
        }
        if(topIndex1 == -1 || topIndex2 == -1 || topIndex1 != topIndex2)
            return false;
        
        return topIndex1 == topIndex2;
    }
}

class Solution {
    public boolean validMountainArray(int[] A) {
        int N = A.length;
        int i = 0;

        // walk up
        while (i+1 < N && A[i] < A[i+1])
            i++;

        // peak can't be first or last
        if (i == 0 || i == N-1)
            return false;

        // walk down
        while (i+1 < N && A[i] > A[i+1])
            i++;

        return i == N-1;
    }
}
