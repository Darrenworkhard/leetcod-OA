package Sorting;

import java.util.*;

class Program {
  public static int[] selectionSort(int[] array) {
		
		for(int i = 0; i < array.length; i++)
		{
			int minidx = i;
			for(int j = i; j < array.length; j++)
			{
				if(array[minidx] > array[j])
				{
					minidx = j;
				}
			}
			int temp = array[i];
			array[i] = array[minidx];
			array[minidx] = temp;
			
		}
    // Write your code here.
    return array;
  }
}
