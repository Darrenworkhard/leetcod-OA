package Good.Easy;
import java.util.*;
public class LC1337_TheKWeakestRows {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Integer>[] listArray = new ArrayList[mat[0].length+2];
        for(int i = 0; i < mat.length; i++)
        {
            int maxSoldier = searchOne(mat[i])+1;
            //System.out.println(maxSoldier);
            if(listArray[maxSoldier] == null)
                listArray[maxSoldier] = new ArrayList<Integer>();
            
            listArray[maxSoldier].add(i);
        }
        int[] ret = new int[k];
        int index = 0;
        for(List<Integer> list : listArray)
        {
            if(list == null)
                continue;
            else
            {
                for(int idx : list)
                {
                    if(index == k)
                        return ret;
                    else
                    {
                        ret[index++] = idx;
                    }         
                }
            }
        }
        return ret;
    }
    int searchOne(int[] arr)
    {
        int l = 0, r = arr.length;
        while(l < r)
        {
            //System.out.println(l + "/" + r);
            int mid = l + (r - l) / 2;
            if(arr[mid] == 1)
                l = mid + 1;
            else if(arr[mid] == 0)
                r = mid;
            //System.out.println(l + "/" + r);
            //System.out.println("---");
                
        }
        return l;
    }
    public static int lowerBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lb = -1, ub = nums.length;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] < target) {
                lb = mid;
            } else {
                ub = mid;
            }
        }

        return lb + 1;
    }

    /*
    * nums[index] <= target, max(index)
    */
    public static int upperBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lb = -1, ub = nums.length;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] > target) {
                ub = mid;
            } else {
                lb = mid;
            }
        }

        return ub - 1;
    }
}
