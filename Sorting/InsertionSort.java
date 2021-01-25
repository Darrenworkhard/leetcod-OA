package Sorting;

public class InsertionSort {
    public static int[] insertionSort(int[] array) {
        for(int i = 1; i < array.length; i++)
            {
                int idx = i;
                for(int j = i-1; j >= 0; j--)
                {
                    if(array[idx] < array[j])
                    {
                        int temp = array[idx];
                        array[idx] = array[j];
                        array[j] = temp;
                        idx = j;
                    }
                }
            }
        return array;
      }
}
