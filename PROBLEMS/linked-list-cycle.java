/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // Handle base cases: empty list or single node
        if (head == null || head.next == null) {
            return false;
        }
        
        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        
        // Traverse the list
        while (fast != null && fast.next != null) {
            // Move slow one step
            slow = slow.next;
            
            // Move fast two steps
            fast = fast.next.next;
            
            // Check if pointers meet (cycle detected)
            if (slow == fast) {
                return true;
            }
        }
        
        // No cycle found
        return false;
    }
}


I'll provide the complete solution for the Linked List Cycle problem with the implemented code.

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // Handle base cases: empty list or single node
        if (head == null || head.next == null) {
            return false;
        }
        
        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        
        // Traverse the list
        while (fast != null && fast.next != null) {
            // Move slow one step
            slow = slow.next;
            
            // Move fast two steps
            fast = fast.next.next;
            
            // Check if pointers meet (cycle detected)
            if (slow == fast) {
                return true;
            }
        }
        
        // No cycle found
        return false;
    }
}

```

Let me break down the solution for you:

### Detailed Explanation

1. **Base Case Check**:
   - If the list is empty (`head == null`) or has only one node (`head.next == null`), return `false`
   - No cycle possible in these scenarios

2. **Two-Pointer Initialization**:
   - `slow` pointer moves one step at a time
   - `fast` pointer moves two steps at a time

3. **Cycle Detection Logic**:
   - Traverse the list using a while loop
   - Conditions: `fast != null && fast.next != null`
   - Move `slow` one step: `slow = slow.next`
   - Move `fast` two steps: `fast = fast.next.next`
   - If `slow` and `fast` meet at the same node, a cycle exists

4. **Return Value**:
   - `true` if a cycle is detected
   - `false` if no cycle is found (fast reaches the end of the list)

### Example Walkthrough

Consider the list: `3 -> 2 -> 0 -> -4 -> (back to 2)`

1. Initial State:
   - `slow` = 3
   - `fast` = 3

2. First Iteration:
   - `slow` moves to 2
   - `fast` moves to 0

3. Second Iteration:
   - `slow` moves to 0
   - `fast` moves to -4

4. Third Iteration:
   - `slow` moves to -4
   - `fast` moves to 2

5. Fourth Iteration:
   - `slow` moves to 2
   - `fast` moves to 0

6. Cycle Detected:
   - `slow` and `fast` meet at the same node (2)
   - Returns `true`

### Complexity Analysis
- **Time Complexity**: O(n)
  - Worst case: traversing the entire list
- **Space Complexity**: O(1)
  - Using only two pointers, constant extra space

This solution efficiently detects cycles in a linked list using the Floyd's Cycle-Finding Algorithm (Tortoise and Hare method).
