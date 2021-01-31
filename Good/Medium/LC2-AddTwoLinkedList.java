public class LC2-AddTwoLinkedList {
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        int remain = 0;
        while(l1 != null || l2 != null)
        {
            int n1 = 0, n2 = 0;
            if(l1 != null)
                n1 = l1.val;
            if(l2 != null)
                n2 = l2.val;
            int num = n1 + n2 + remain;
            remain = num / 10;
            num = num % 10;
            node.next = new ListNode(num);
            node = node.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(remain != 0)
            node.next = new ListNode(remain);
        return dummy.next;
    }

}
