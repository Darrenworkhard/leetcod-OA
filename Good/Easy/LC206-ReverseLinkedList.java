/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
       if(head == null) return null;
        
        ListNode newNode = null;
        while(head != null)
        {
            ListNode temp = head.next;
            head.next = newNode;
            newNode = head;
            head = temp;
           

            
        }
        
        return newNode;
    }
}