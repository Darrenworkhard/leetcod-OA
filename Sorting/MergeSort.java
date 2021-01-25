package Sorting;

//O(nlogn)
public class MergeSort {
    public static int[] mergeSort(int[] array) {
        // Write your code here.
            
        return devide(array, 0, array.length-1);
      }
        static int[] devide(int[] array, int l, int r)
        {
            if(l == r) return new int[]{array[l]};
            int mid = l + (r - l) / 2;
            int[] devideL = devide(array, l, mid);
            int[] devideR = devide(array, mid+1, r);
    
            return merge(devideL, devideR);
        }
        static int[] merge(int[] l, int[] r)
        {
            int[] newArr = new int[l.length + r.length];
            int lidx = 0, ridx = 0, idx = 0;
    
            while(lidx < l.length || ridx < r.length)
            {
                if(ridx >= r.length) newArr[idx++] = l[lidx++];
                else if(lidx >= l.length) newArr[idx++] = r[ridx++];
                else if(l[lidx] > r[ridx])
                {
                    newArr[idx++] = r[ridx];
                    ridx++;
                }
                else
                {
                    newArr[idx++] = l[lidx];
                    lidx++;
                }
            }
            return newArr;
                
        }
}
