**Find All Missing Numbers in an Array**

**Problem:** Given an array `nums` of size `n`, where elements are in the range `[1, n]`, find all missing numbers.

**Easy Approach (Using HashSet):**
1. Store all numbers from `nums` in a **HashSet**.
2. Iterate from `1 to n` and check which numbers are missing.
3. Return the missing numbers.

**Code:**
```java
import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        for (int num : nums) set.add(num); // Store numbers in HashSet
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) result.add(i); // Find missing numbers
        }
        return result;
    }
}
```

**Example:**
```
Input:  [4,3,2,7,8,2,3,1]
Output: [5,6]
```

**Time Complexity:** `O(n)`, **Space Complexity:** `O(n)`.

For an efficient `O(1)` space solution, use in-place marking by negating values at corresponding indices.
Example Input:
java
Copy
Edit
nums = [4,3,2,7,8,2,3,1]
Step 1: Store Elements in a HashSet
We add all numbers to a HashSet {1, 2, 3, 4, 7, 8}.
Step 2: Find Missing Numbers
Now, we check all numbers from 1 to n (1 to 8):
1 → ✅ Found in HashSet
2 → ✅ Found in HashSet
3 → ✅ Found in HashSet
4 → ✅ Found in HashSet
5 → ❌ Not in HashSet → Missing
6 → ❌ Not in HashSet → Missing
7 → ✅ Found in HashSet
8 → ✅ Found in HashSet
Final Output: [5, 6]
The numbers 5 and 6 are missing from nums, so they are added to the result list.
