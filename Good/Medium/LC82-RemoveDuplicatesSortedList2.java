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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        while(head != null)
        {
            boolean isDuplicate = false;
            while(head.next != null && head.val == head.next.val)
            {
                head = head.next;
                isDuplicate = true;
            }
            if(isDuplicate)
            {
                head = head.next;
                continue;
            }
   
            node.next = head;
            head = head.next;
            node = node.next;
        }
        node.next = null;
        return dummy.next;
    }
}