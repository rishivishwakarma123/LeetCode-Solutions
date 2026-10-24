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
    public ListNode reverseLL(ListNode curr){
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
  
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow  = slow.next;
            fast = fast.next.next;

        }
        //now we found middle element is slow then reverse the half link list

        ListNode n1 = reverseLL(slow);
        ListNode n2 = head;

        // how compaire with n2 and n1 element data is same or not

        while(n1 != null &&  n2 != null){

            if(n1.val != n2.val){
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;

        }
        
        return true;
    }
}