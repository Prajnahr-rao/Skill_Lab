# Squares of a Sorted Array - Solution & Explanation

## Problem 977: Squares of a Sorted Array

### Solution Code
```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Two pointers approach
        int left = 0;
        int right = n - 1;
        
        // Fill the result array from the end (largest elements first)
        for (int i = n - 1; i >= 0; i--) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            if (leftSquare > rightSquare) {
                result[i] = leftSquare;
                left++;
            } else {
                result[i] = rightSquare;
                right--;
            }
        }
        
        return result;
    }
}
```

### Key Points
1. **Two-Pointer Approach**: The solution uses two pointers to track potential largest squared values
2. **Building Result Backwards**: We build the result array from the end (largest to smallest)
3. **Handling Negatives**: The key insight is that the largest squared values will be at either end of the array due to the original array being sorted
4. **Time Complexity**: O(n) - Each element is processed exactly once
5. **Space Complexity**: O(n) - Result array of the same size as input

### Example Walkthrough
For the input array: `[-4, -1, 0, 3, 10]`

**Iteration 1:**
- left = 0 (value = -4), right = 4 (value = 10)
- leftSquare = 16, rightSquare = 100
- 16 < 100, so result[4] = 100, right = 3

**Iteration 2:**
- left = 0 (value = -4), right = 3 (value = 3)
- leftSquare = 16, rightSquare = 9
- 16 > 9, so result[3] = 16, left = 1

**Iteration 3:**
- left = 1 (value = -1), right = 3 (value = 3)
- leftSquare = 1, rightSquare = 9
- 1 < 9, so result[2] = 9, right = 2

**Iteration 4:**
- left = 1 (value = -1), right = 2 (value = 0)
- leftSquare = 1, rightSquare = 0
- 1 > 0, so result[1] = 1, left = 2

**Iteration 5:**
- left = 2 (value = 0), right = 2 (value = 0)
- leftSquare = 0, rightSquare = 0
- Equal, so result[0] = 0, right = 1

Final result: `[0, 1, 9, 16, 100]`
