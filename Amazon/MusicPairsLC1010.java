class MusicPairsLC1010 {
    public static void main(String[] args) {
        String[] from = new String[] {"88 99 200", "88 99 300", "99 32 100", "12 12 15"};
        int[] scores = new int[] {1,2,3,4,5};
         
        int ans = numPairsDivisibleBy60(scores);
        System.out.print("Hello");
    }
    public static int numPairsDivisibleBy60(int[] time) {
        // int[] c  = new int[60];
        // int res = 0;
        //same
        int c[]  = new int[60], res = 0;
        for (int t : time) {
            res += c[(60 - t % 60) % 60];
            c[t % 60] += 1;
        }
        return res;
   }
}