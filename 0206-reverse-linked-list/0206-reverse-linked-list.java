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
    public ListNode reverseList(ListNode head) {

        ListNode current=head;


        ListNode previous = null;
        ListNode prvNext =null;


        while(current!=null){
            prvNext= previous;
            previous =current;
            current= current.next;
            previous.next = prvNext;


        }

        return previous;


        
    }
}