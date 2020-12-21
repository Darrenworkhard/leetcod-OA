//T(N)
//S(1)

class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode notNine = dummy;
        dummy.next = head;
        while(head != null)
        {
            if(head.val != 9)
                notNine = head;
            
            head = head.next;
        }
        notNine.val++;
        notNine = notNine.next;
        while(notNine != null)
        {
            notNine.val = 0;
            notNine = notNine.next;
        }
        
        return dummy.val == 0 ? dummy.next : dummy;
    }
}

//T(N^2)
//S(1)
class Solution {
    public ListNode plusOne(ListNode head) {
        int len = 0;
        ListNode node = head;
        while(node != null)
        {
            node = node.next;
            len++;
        }
        return plus(head, --len);
    }
    ListNode plus(ListNode head, int len)
    {
        ListNode node = head;
        if(len == 0)
        {
            if(node.val + 1 >= 10)
            {
                node.val = 0;
                ListNode ret = new ListNode(1);
                ret.next = head;
                return ret;
            }
            else
            {
                node.val += 1;
                return head;
            }
                
        }
        
        int count = 0;
        while(node != null && count <= len)
        {
            if(count == len)
            {
                if(node.val + 1 >= 10)
                {
                    node.val = 0;
                    return plus(head, len-1);
                }
                else
                    node.val += 1;
            }
            count++;
            node = node.next;
        }
        return head;
    }
}