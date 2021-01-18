import java.util.HashMap;

import org.w3c.dom.Node;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    //S1
    HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        if(map.containsKey(head))
            return map.get(head);
            
        Node node = new Node(head.val);
        map.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }
}
class Solution {
    //S2
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        int index = 0;
        Node dummy = new Node(0);
        Node node = dummy;
        Node org = head;
  
        while(head != null)
        {           
            Node t = head.random;
            node.next = new Node(head.val);  
            node.next.random = t;
            node = node.next;        
            head = head.next;            
        }

        node = dummy.next;
        while(org != null)
        {
            map.put(org, node);
            node = node.next;
            org = org.next;
        }
        node = dummy.next;
        while(node != null)
        {
            Node t = node.random;
            if(node.random != null)
                node.random = map.get(node.random);
            else
                node.random = null;
            
            node = node.next;
        }
        return dummy.next;
        
    }
}