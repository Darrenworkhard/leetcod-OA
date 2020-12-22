
//https://docs.google.com/document/d/1zzVrn4VYPDsn2klG4IeZOJo3yYW8VfU9BVNN0Nr_nO0/edit?usp=sharing
//Time O(N)
//Space O(1)
import java.util.*;
import java.io.*;
import java.lang.*;

public class AutoscalePolicy_UtilizationChecks {
    public static void main(String[] args)
    {
        List<Integer> util = new ArrayList<>();
        util.add(5);
        util.add(10);
        util.add(80);
        // util.add(2);
        // util.add(3);
        // util.add(4);
        // util.add(5);
        // util.add(6);
        // util.add(7);
        // util.add(8);
        // util.add(9);
        // util.add(10);
        // util.add(76);
        // util.add(80);

        int[] averageUtil = {30,95,4,8,19,89};
        int ans = finalInstances(100000000, averageUtil);

        System.out.print("Hello");
    }
    public static int finalInstances(int instances, int[] averageUtil) {
        if(averageUtil.length == 0) return instances;
        double ret = (double)instances;
        double noExceed = 2 * Math.pow(10, 8);
        for(int i = 0; i < averageUtil.length; i++)
        {
            int utilize = averageUtil[i];
            if(utilize > 60)
            {
                double newInstances = ret * 2;
                if(newInstances <= noExceed)
                {
                    ret = newInstances;
                    i += 10;
                }
            }
            else if(utilize < 25 && ret > 1)
            {
                double ceiling = ret/2.0;
                ret = Math.ceil(ceiling);
                i += 10;
            }
        }
        
        return (int)ret;
    }

    // public static int Autoscale(int instance, List<Integer> util)
    // {
    //     if(util.size() == 0) return instance;

    //     for(int i = 0; i < util.size(); i++)
    //     {
    //         int utilize = util.get(i);
    //         if(utilize > 60)
    //         {
    //             int newInstance = instance*2;
    //             int notExceed = 2 * 10^8;
    //             if(newInstance < notExceed)
    //             {
    //                 instance = newInstance;
    //                 i += 10;
    //             }
    //         }
    //         else if(utilize < 25 && instance > 1)
    //         {
    //             double ceiling = (double)instance/2.0;
    //             int newInstance = (int)Math.ceil(ceiling);
    //             instance = newInstance;
    //             i += 10;

    //         }
    //     }

    //     return instance;

    // }
}
