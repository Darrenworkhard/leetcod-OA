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

import java.util.*;
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        node.next = head;
        while(node.next != null && node.next.next != null)
        {
            //1234
            ListNode first = node.next;
            //234
            ListNode second = node.next.next;
            //134
            first.next = second.next;
            node.next = second;
            node.next.next = first;
            node = node.next.next;
            
        }
        return dummy.next;
    }
}