/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
#include <stdlib.h>

struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    // Create a dummy node to handle edge cases (like removing the head node)
    struct ListNode dummy;
    dummy.next = head;
    
    struct ListNode *fast = &dummy;
    struct ListNode *slow = &dummy;
    
    // Move fast n + 1 steps ahead to maintain a gap of n nodes between fast and slow
    for (int i = 0; i <= n; i++) {
        if (fast == NULL) return head; // Safety check if n is larger than list length
        fast = fast->next;
    }
    
    // Move both pointers until fast reaches the end of the list
    while (fast != NULL) {
        fast = fast->next;
        slow = slow->next;
    }
    
    // slow->next is the target node to be removed
    struct ListNode *toDelete = slow->next;
    slow->next = slow->next->next;
    
    // Free the memory of the removed node
    free(toDelete);
    
    return dummy.next;
}