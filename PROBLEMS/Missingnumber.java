
public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }
    
    public static void main(String[] args) {
        // Create an instance of the Solution class
        Solution solution = new Solution();
        
        // Example 1: [3,0,1]
        int[] example1 = {3, 0, 1};
        
        // Call the missingNumber method
        int result = solution.missingNumber(example1);
        
        // Print the result
        System.out.println("Input: [3,0,1]");
        System.out.println("Output: " + result);
        System.out.println("Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. " +
                          "2 is the missing number in the range since it does not appear in nums.");
    }
}
























# Main Logic of the Missing Number Solution

The main logic of this solution centers on a mathematical trick that makes finding the missing number efficient and elegant:

**1. Using the Sum Formula**
- The key insight is to use the formula for the sum of consecutive integers from 0 to n: `n * (n + 1) / 2`
- This formula gives us the expected sum if no numbers were missing

**2. Finding the Difference**
- We know that exactly one number is missing from our array
- By calculating the actual sum of array elements and subtracting it from the expected sum, we can identify the missing number

**3. Implementation Details**
```java
int n = nums.length;                // The array has n elements
int expectedSum = n * (n + 1) / 2;  // Sum of numbers 0 to n
int actualSum = 0;                  // Initialize actual sum
    
for (int num : nums) {              // Calculate actual sum
    actualSum += num;
}
    
return expectedSum - actualSum;     // The difference is our missing number
```

**4. Example Walkthrough** with `[3,0,1]`:
- n = 3 (array length)
- Expected sum = 3*(3+1)/2 = 6 (this is the sum of 0+1+2+3)
- Actual sum = 3+0+1 = 4
- Missing number = Expected - Actual = 6-4 = 2

This approach is particularly efficient because it requires only a single pass through the array and uses constant extra space.