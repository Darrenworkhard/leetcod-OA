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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int len = 1;
        ListNode node = head;
        while(node.next != null)
        {
            node = node.next;
            len++;
        }
        
        if(k % len == 0) return head;
        //cycle
        node.next = head;
        node = node.next;
        ListNode ans = node;
        int num = len - (k % len);
        int i = 0;
        while((i + k) % len != 0)
        {
            //@26 next @28
            ans = node;
            //@28
            node = node.next;
            i++;
        }
        //Delete @28 but assign variable didn't effect like node
        //Break the cycle
        ans.next = null;
        return node;
    }
}
