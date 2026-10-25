/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

// Separate helper function to reverse any linked list
struct ListNode* reverseList(struct ListNode* head) {
    struct ListNode* prev = NULL;
    struct ListNode* current = head;
    
    while (current != NULL) {
        struct ListNode* nextTemp = current->next;
        current->next = prev;
        prev = current;
        current = nextTemp;
    }
    
    return prev;
}

int pairSum(struct ListNode* head) {
    // Find middle node using fast and slow pointers
    struct ListNode* slow = head;
    struct ListNode* fast = head;

    while (fast != NULL && fast->next != NULL) {
        slow = slow->next;
        fast = fast->next->next;
    }
    // Middle node found

    // Reverse linked list using slow
    struct ListNode* n1 = reverseList(slow);
    struct ListNode* n2 = head;

    // Calculate sum
    int max = INT_MIN;

    while (n1 != NULL && n2 != NULL) {
        int sum = n1->val + n2->val;

        if (sum > max) {
            max = sum;
        }
        n1 = n1->next;
        n2 = n2->next;
    }

    return max;
}