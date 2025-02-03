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
    int carry = 0;
    public void createDoubleList(ListNode node) {
        if( node.next != null ) {
            createDoubleList(node.next);
        }
        int newvalue = 2*node.val+carry;
        node.val = newvalue%10;
        carry = newvalue/10;
        return;
    }
    
    public ListNode doubleIt(ListNode head) {
        if( head == null ) return head;
        carry = 0;
        createDoubleList(head);
        if( carry == 1) {
            ListNode newNode = new ListNode(1);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
}
