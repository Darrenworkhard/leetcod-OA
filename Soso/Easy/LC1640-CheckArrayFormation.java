package Soso.Easy;
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap();
        for (int[] piece : pieces)
            map.put(piece[0], piece);

        int[] result = new int[arr.length];
        int ind = 0;
        for (int a : arr)
            for (int p : map.getOrDefault(a, new int[0]))
                result[ind++] = p;

        return Arrays.equals(arr, result);
    }
}
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < pieces.length; i++)
        {
            map.put(pieces[i][0], i);
        }
        for(int i = 0; i < arr.length; i++)
        {
            if(map.containsKey(arr[i]))
            {
                int index = map.get(arr[i]);               
                int[] piece = pieces[index];
                for(int j : piece)
                {
                    if(arr[i] == j)
                        i++;
                    else
                        return false;
                }
                i--;
            }
            else
                return false;
        }
        return true;
    }
}
