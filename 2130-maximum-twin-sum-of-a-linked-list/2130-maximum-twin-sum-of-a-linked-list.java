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

    // Separate helper function to reverse any linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        
        return prev;
    }

    public int pairSum(ListNode head) {

        //find middle node using fast and slow
        //reverse slow node
        //sum calculate

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
       //middle node found

       //reverse linked list using slow
       ListNode n1 = reverseList(slow);
       ListNode n2 = head;

       //calculate sum
        int max = Integer.MIN_VALUE;

        while(n1 != null && n2 != null){
            int sum = n1.val + n2.val;

            if(sum > max){
                max = sum;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        return max;
    }
}