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

// solution 1: iterative
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)    return null;
        ListNode p1 = head.next;
        ListNode p2 = head;
        p2.next = null;
        ListNode p3 = null;
        while(p1 != null){
            p3 = p1.next;
            p1.next = p2;
            p2 = p1;
            p1 = p3;
        }
        return p2;
    }
}

//solution 2: recursion