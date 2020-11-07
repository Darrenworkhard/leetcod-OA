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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode current = head, pre, next;
        while(current != null)
        {
            pre = dummy;
            next = dummy.next;
            //if next.val > current.val will be descending 
            while(next != null && next.val < current.val)
            {
                pre = next;
                next = next.next;
            }
            ListNode temp = current.next;
            current.next = next;
            pre.next = current;
            current = temp;
        }
        return dummy.next;
    }
}