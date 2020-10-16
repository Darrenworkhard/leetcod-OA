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
    public ListNode sortList(ListNode head) {
        if(head == null) return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        fast = head;
        slow = temp;
        if(fast != null && fast.next != null)
            fast = sortList(fast);
                
        if(slow != null && slow.next != null)
            slow = sortList(slow);
        
        ListNode dummy = new ListNode();
        ListNode node = dummy;

        //merge
        while(fast != null && slow != null)
        {
            if(fast.val > slow.val)
            {
                node.next = slow;
                slow = slow.next;
                node = node.next;
            }
            else
            {
                node.next = fast;
                fast = fast.next;
                node = node.next;
            }
        }
        if(fast != null)
            node.next = fast;
        if(slow != null)
            node.next = slow;
        
        return dummy.next;
       
    }
}
