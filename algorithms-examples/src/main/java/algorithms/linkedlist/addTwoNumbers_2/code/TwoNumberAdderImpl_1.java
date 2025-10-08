package algorithms.linkedlist.addTwoNumbers_2.code;

import algorithms.linkedlist.ListNode;

public class TwoNumberAdderImpl_1 implements TwoNumberAdder {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy head node to simplify list construction
        ListNode dummyHead = new ListNode(0);

        // Initialize carry for addition overflow
        int carry = 0;

        // Pointer to track current position in result list
        ListNode current = dummyHead;

        // Continue while there are digits to process or carry exists
        while (l1 != null || l2 != null || carry != 0) {
            // Get current digit values (0 if node is null)
            int digit1 = (l1 == null) ? 0 : l1.val;
            int digit2 = (l2 == null) ? 0 : l2.val;

            // Calculate sum of current digits plus carry
            int sum = digit1 + digit2 + carry;

            // Update carry for next iteration (integer division)
            carry = sum / 10;

            // Create new node with the current digit (remainder after division by 10)
            current.next = new ListNode(sum % 10);

            // Move current pointer to the newly created node
            current = current.next;

            // Move to next nodes in input lists if they exist
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // Return the actual head of result list (skip dummy head)
        return dummyHead.next;
    }
}