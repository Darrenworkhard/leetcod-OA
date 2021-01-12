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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];

        return devideConquer(lists, 0, lists.length-1);
            
    }
    ListNode devideConquer(ListNode[] lists, int start, int end)
    {
        if(start == end)
            return lists[start];
        
        int mid = start + (end - start) / 2;
        ListNode l = devideConquer(lists, start, mid);
        ListNode r = devideConquer(lists, mid+1, end);
        
        return merge2Lists(l,r);
        
    }
    ListNode merge2Lists(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        while(l1 != null && l2 != null)
        {
            if(l1.val > l2.val)
            {
                node.next = l2;
                l2 = l2.next;
            }
            else
            {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        if(l1 != null)
            node.next = l1;
        if(l2 != null)
            node.next = l2;
        
        return dummy.next;
    }
}