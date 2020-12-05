/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    List<Integer> lists = new ArrayList<>();
    public Solution(ListNode head) {
        while(head != null)
        {
            lists.add(head.val);
            head = head.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int rnd = new Random().nextInt(lists.size());
        return lists.get(rnd);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */