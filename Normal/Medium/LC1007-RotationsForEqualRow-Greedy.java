//Solution 1 99%
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        //Key point
        //Why is A[0] or B[0] because if not on two of these, you can't totally one of them.
        int countA = SwapCount(A,B,A[0]);
        int countB = SwapCount(B,A,B[0]);
        if(countA == -1 || countB == -1) return Math.max(countA, countB);
        
        return Math.min(countA, countB);
    }
    int SwapCount(int[] A, int[] B, int num)
    {
        int countA = 0;
        int countB = 0;
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] != num && B[i] != num)
                return -1;
            else if(A[i] != num && B[i] == num)
                countA++;
            else if(B[i] != num && A[i] == num)
                countB++;
        }
        //Reason
        //[1,2,2]
        //[2,1,1]
        return Math.min(countA, countB);
    }  
}

//Solution2 Original 49%
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int len = A.length;
        int[] aA = new int[7];
        int[] aB = new int[7];
        for(int i = 0; i < len; i++)
        {
            aA[A[i]] += 1;
            aB[B[i]] += 1;
        }
        for(int i = 1; i <= 6; i++)
        {
            if(aA[i] + aB[i] >= len -1)
            {
                if(aA[i] > aB[i])
                {
                    return SwapCount(A,B,i);
                }
                else
                {
                    return SwapCount(B,A,i);
                }
            }
        }
        
        return -1;
    }
    int SwapCount(int[] A, int[] B, int num)
    {
        int count = 0;
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] != num && B[i] != num)
                return -1;
            else if(A[i] != num && B[i] == num)
                count++;
            
        }
        return count;
    }
}
