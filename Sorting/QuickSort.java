package Sorting;

public class QuickSort {
    public static int[] quickSort(int[] array) {
        // Write your code here.
            quickSort(array, 0, array.length-1);
        return array;
      }
        static void quickSort(int[] array, int s, int e)
        {
            if(s >= e) return;
            int pivotIndex = findPartition(array, s, e);
            quickSort(array, s, pivotIndex-1);
            quickSort(array, pivotIndex+1, e);
            return;
        }
        static int findPartition(int[] array, int s, int e)
        {
            if(s == e) return s;
            int pivot = s - 1;
            for(int i = s; i <= e; i++)
            {
                if(array[i] <= array[e])
                {
                    int temp = array[++pivot];
                    array[pivot] = array[i];
                    array[i] = temp;
                }
            }
            return pivot;
        }
}
