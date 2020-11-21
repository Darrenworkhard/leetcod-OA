class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;
        //****Can't use on large scale data
        //Arrays.sort(intervals, (x,y) -> x[0] < y[0] ? -1 : 1);
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        //or
        Arrays.sort(intervals, (a, b) -> { return a[0] - b[0];});
        Stack<Integer> s = new Stack<Integer>();
        List<int[]> list = new ArrayList<>();
        for(int[] i : intervals)
        {
            if(s.isEmpty())
            {
                s.add(i[0]);
                s.add(i[1]);
            }
            else
            {
                if(i[0] > s.peek())
                {
                    int[] newInt = new int[2];
                    newInt[1] = s.pop();
                    newInt[0] = s.pop();
                    list.add(newInt);
                    s.add(i[0]);
                    s.add(i[1]);
                }
                else if(i[1] > s.peek())
                {
                    s.pop();
                    s.add(i[1]);
                }
            }
        }
        if(!s.isEmpty())
        {
            int[] newInt = new int[2];
            newInt[1] = s.pop();
            newInt[0] = s.pop();
            list.add(newInt);
        }
        int[][] ret = new int[list.size()][];
        for(int i = 0; i < list.size(); i++)
        {
            ret[i] = list.get(i);
        }
        return ret;
    }
}