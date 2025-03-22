# Longest Mountain in Array - Solution & Explanation

## Problem 845: Longest Mountain in Array

### Solution Code
```java
class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int maxLength = 0;
        
        // Need at least 3 elements to form a mountain
        if (n < 3) return 0;
        
        int i = 1;
        while (i < n - 1) {
            // Check if current element is a potential peak
            boolean isPeak = arr[i - 1] < arr[i] && arr[i] > arr[i + 1];
            
            if (!isPeak) {
                i++;
                continue;
            }
            
            // Extend left side of the mountain
            int leftIdx = i - 1;
            while (leftIdx > 0 && arr[leftIdx - 1] < arr[leftIdx]) {
                leftIdx--;
            }
            
            // Extend right side of the mountain
            int rightIdx = i + 1;
            while (rightIdx < n - 1 && arr[rightIdx] > arr[rightIdx + 1]) {
                rightIdx++;
            }
            
            // Calculate mountain length and update max
            int currentLength = rightIdx - leftIdx + 1;
            maxLength = Math.max(maxLength, currentLength);
            
            // Skip to the end of this mountain
            i = rightIdx + 1;
        }
        
        return maxLength;
    }
}
```

### Key Points
1. **Single Pass Algorithm**: We identify mountains and measure them in one traversal
2. **Peak Identification**: We find potential peaks where arr[i-1] < arr[i] > arr[i+1]
3. **Mountain Expansion**: From each peak, we expand both left and right to find full extent
4. **Optimization**: We skip to the end of each mountain to avoid redundant checks
5. **Time Complexity**: O(n) - Each element is examined at most twice
6. **Space Complexity**: O(1) - We use only a few variables

### Example Walkthrough
For the input array: `[2, 1, 4, 7, 3, 2, 5]`

**Initial check:**
- Array length = 7, which is ≥ 3, so we continue

**Iteration 1 (i=1):**
- Check if arr[1]=1 is a peak: 2 < 1 > 4? => FALSE
- Move to next element (i=2)

**Iteration 2 (i=2):**
- Check if arr[2]=4 is a peak: 1 < 4 > 7? => FALSE
- Move to next element (i=3)

**Iteration 3 (i=3):**
- Check if arr[3]=7 is a peak: 4 < 7 > 3? => TRUE
- Expand left from i=2:
  - Check 1 < 4? YES, leftIdx = 1
  - Check 2 < 1? NO, stop at leftIdx = 1
- Expand right from i=4:
  - Check 3 > 2? YES, rightIdx = 5
  - Check 2 > 5? NO, stop at rightIdx = 5
- Mountain length = 5-1+1 = 5
- Update maxLength = 5
- Skip to i = 6

**Iteration 4 (i=6):**
- Not enough elements for a peak (need element after)
- End of loop

Final result: maxLength = 5 (mountain [1,4,7,3,2])
