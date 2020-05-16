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
    public ListNode oddEvenList(ListNode head) {
        if(head == null)    return null;
        ListNode even_head = head.next;
        if(even_head == null)   return head;
        ListNode even_p = even_head;
        ListNode odd_p = head;
        while(odd_p.next != null && even_p.next != null){
            odd_p.next = even_p.next;
            if(odd_p.next != null)
                odd_p = odd_p.next;
            even_p.next = odd_p.next;
            if(even_p.next != null)
                even_p = even_p.next;
        }
        odd_p.next = even_head;
        return head;
    }
}