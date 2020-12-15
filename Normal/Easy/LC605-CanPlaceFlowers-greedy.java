class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) return true;
        if(flowerbed.length == 1) return flowerbed[0] == 0;
        for(int i = 0; i < flowerbed.length; i++)
        {
            if(flowerbed[i] == 0 && canPlace(flowerbed, i))
            {
                flowerbed[i] = 1;
                n--;
            }
            if(n == 0)
                return true;
        }
        
        return false;
    }
    boolean canPlace(int[] bed, int index)
    {
        if(index == 0)
            return bed[index+1] == 0;
        else if(index == bed.length-1)
            return bed[index-1] == 0;
        else
            return bed[index+1] == 0 && bed[index-1] == 0;
               
    }
}