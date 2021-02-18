import java.util.PriorityQueue;
public class Test {
    /**
     *  algorithm
     *  1. Count each letter frequency
     *  2. Put frequency into PriorityQueue
     *  3. Every time put one frequency out, if freq > then top one, then skip
     *     If freq == top one, then result++, when freq > 1 then minus one, put it back to queue.
     *  4. return sum;
     * @param s
     * @return
     */
    public int solution(String s){
        int[] map = new int[26];
        char [] arr = s.toCharArray();
        for(int i = 0;i < arr.length;i++){
            map[arr[i]-'a']++;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->{return b-a;});
        for(int c:map){
            if(c > 0)
                q.add(c);
        }
        int result = 0;
        while(!q.isEmpty() ){
            int freq = q.poll();
            if(q.isEmpty())
                return result;
            if(freq == q.peek()){
                result++;
                if(freq > 1)
                    q.add(freq-1);
            }
        }
        return result;
    }
    public static void main(String[] args){
        Test obj = new Test();
        obj.test("aaabbb", 1);
        obj.test("aabb", 1);
        obj.test("aaabbffddeee", 6);
        obj.test("llll", 0);
    }
    public void test(String param, int ans){
        int res = solution(param);
        boolean result = res == ans;
        System.out.printf("param: %s, ans: %s, res: %s \n", param, res, result);

    }
}
