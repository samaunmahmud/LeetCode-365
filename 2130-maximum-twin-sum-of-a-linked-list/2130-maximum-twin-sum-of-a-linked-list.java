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
    public int pairSum(ListNode head) {

        if(head == null || head.next== null){
            return 0;
        }


        ListNode slow = head;
        ListNode fast = head;



        while(fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode previous = null;
        ListNode current = slow;

        while(current!= null){
            ListNode nextTemp =current.next;
            current.next = previous;
            previous = current;
            current = nextTemp;
        }



        int maxSum =0;


        ListNode firstHalf = head;
        ListNode secondHalf = previous;

        while(secondHalf!= null){
            int sum = firstHalf.val+ secondHalf.val;

            if(sum>maxSum){
                maxSum = sum;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;


        }

        return maxSum;
        
    }
}