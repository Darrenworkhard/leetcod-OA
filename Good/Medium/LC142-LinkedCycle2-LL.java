//Solution 1 **Note check cycle way is different then solution 2
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            if (fast.next == null) return null;
            fast = fast.next.next;
            if(slow == fast) 
            {
                isCycle = true;
                break;
            }
        }
        if(!isCycle)
        {
            return null;
        }
        //proven by math
        slow = head;
        while(slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
          
        }
        return slow;
    }
}



//Solution 2 pass but slow
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        boolean isCycle = true;
        while(slow != fast)
        {
            if(fast == null || fast.next == null)
            {
                isCycle = false;
                break;
            }
                
            slow = slow.next;
            fast = fast.next.next;
        }
        if(!isCycle)
        {
            return null;
        }
        ListNode begin = head;
        ListNode cycle = slow;
        while(begin != cycle)
        {
            slow = slow.next;
            while(cycle != slow)
            {  
                if(begin == slow)
                    return begin;
                slow = slow.next;
            }
            begin = begin.next;
        }
        return begin;
    } 
}