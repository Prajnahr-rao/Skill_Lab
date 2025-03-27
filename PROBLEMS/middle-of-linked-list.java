class Solution {
    public ListNode middleNode(ListNode head) {
        // If the list is empty or has only one node, return the head
        if (head == null || head.next == null) {
            return head;
        }
        
        // Initialize two pointers: slow and fast
        // Slow pointer moves one step at a time
        // Fast pointer moves two steps at a time
        ListNode slow = head;
        ListNode fast = head;
        
        // Move fast pointer two steps and slow pointer one step
        // When fast reaches the end, slow will be at the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;     // Move slow one step
            fast = fast.next.next; // Move fast two steps
        }
        
        // When fast reaches the end, slow will be at the middle node
        return slow;
    }
}




class Solution {
    public ListNode middleNode(ListNode head) {
        // If the list is empty or has only one node, return the head
        if (head == null || head.next == null) {
            return head;
        }
        
        // Initialize two pointers: slow and fast
        // Slow pointer moves one step at a time
        // Fast pointer moves two steps at a time
        ListNode slow = head;
        ListNode fast = head;
        
        // Move fast pointer two steps and slow pointer one step
        // When fast reaches the end, slow will be at the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;     // Move slow one step
            fast = fast.next.next; // Move fast two steps
        }
        
        // When fast reaches the end, slow will be at the middle node
        return slow;
    }
}

```
### Approach: Two-Pointer Technique (Slow and Fast Pointers)

1. **Base Case Handling**:
   - If the list is empty (`head == null`) or has only one node (`head.next == null`), return the head.

2. **Pointer Initialization**:
   - Create two pointers: `slow` and `fast`
   - Both start at the head of the linked list
   - `slow` moves one step at a time
   - `fast` moves two steps at a time

3. **Traversal Logic**:
   - While `fast` is not null and `fast.next` is not null:
     - Move `slow` one step forward
     - Move `fast` two steps forward
   - When `fast` reaches the end of the list, `slow` will be at the middle node

### Trace Example

Let's trace the algorithm with the input `[1,2,3,4,5]`:

Initial state:
- `slow` = 1
- `fast` = 1

1st Iteration:
- `slow` moves to 2
- `fast` moves to 3

2nd Iteration:
- `slow` moves to 3
- `fast` moves to 5

3rd Iteration:
- `fast` reaches the end (null)
- `slow` is now at 3 (the middle node)

### Time and Space Complexity
- **Time Complexity**: O(N), where N is the number of nodes
- **Space Complexity**: O(1), as we're using only two pointers

### Handling Even-Length Lists
- For even-length lists (like `[1,2,3,4,5,6]`), the algorithm naturally returns the second middle node (4)

### Key Insights
- The fast pointer moves twice as quickly as the slow pointer
- When the fast pointer reaches the end, the slow pointer will be at the middle
- Works for both odd and even-length lists

This solution elegantly solves the problem with a single pass through the linked list, making it both time and space efficient.