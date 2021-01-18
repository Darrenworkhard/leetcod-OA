class Solution {
    public int numRescueBoats(int[] people, int limit) {
       int boats = 0;
       
       Arrays.sort(people);
       int left = 0;
       int right = people.length - 1;
       
       while (left < right) {
           if (people[right] + people[left] <= limit) {
               boats++;
               right--;
               left++;
           }
           
           else {
               boats++;
               right--;
           }
       }
       
       if (left == right) {
           boats++;
       }
       
       return boats;
   }
}