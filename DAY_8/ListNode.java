// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

// Solution class to remove the nth node from the end of the list
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to handle edge cases (e.g., removing the head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize two pointers
        ListNode first = dummy;
        ListNode second = dummy;

        // Move the first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until the first pointer reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node from the end
        second.next = second.next.next;

        // Return the new head of the list
        return dummy.next;
    }
}

// Main class to test the solution
public class Main {
    public static void main(String[] args) {
        // Helper function to create a linked list from an array
        ListNode createLinkedList(int[] arr) {
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;
            for (int num : arr) {
                current.next = new ListNode(num);
                current = current.next;
            }
            return dummy.next;
        }

        // Helper function to print a linked list
        void printLinkedList(ListNode head) {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        }

        // Example 1
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode head1 = createLinkedList(arr1);
        System.out.println("Example 1:");
        System.out.print("Input: ");
        printLinkedList(head1);
        Solution solution = new Solution();
        ListNode result1 = solution.removeNthFromEnd(head1, 2);
        System.out.print("Output: ");
        printLinkedList(result1); // Expected: [1, 2, 3, 5]

        // Example 2
        int[] arr2 = {1};
        ListNode head2 = createLinkedList(arr2);
        System.out.println("\nExample 2:");
        System.out.print("Input: ");
        printLinkedList(head2);
        ListNode result2 = solution.removeNthFromEnd(head2, 1);
        System.out.print("Output: ");
        printLinkedList(result2); // Expected: []

        // Example 3
        int[] arr3 = {1, 2};
        ListNode head3 = createLinkedList(arr3);
        System.out.println("\nExample 3:");
        System.out.print("Input: ");
        printLinkedList(head3);
        ListNode result3 = solution.removeNthFromEnd(head3, 1);
        System.out.print("Output: ");
        printLinkedList(result3); // Expected: [1]
    }
}