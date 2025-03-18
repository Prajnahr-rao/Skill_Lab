Explanation:

The Two Sum problem requires finding two indices in an array where the sum of the elements at those indices equals a target value.
We use a HashMap to store the values and their indices as we traverse the array. For each number, we check if the complement (i.e., target - current number) exists in the map.
If the complement exists, we've found the solution and return the indices of the two numbers.
Explanation of Logic:

We use a HashMap to store each number and its index as we iterate over the array.
For each element in the array, we calculate the complement (i.e., target - nums[i]).
If the complement is already in the map, we return the indices of the current number and the complement from the map.
If no complement is found, we add the current number and its index to the map.
This approach ensures an O(n) time complexity.




import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a map to store the number and its index
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];  // The complement we are looking for
            
            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // If found, return the indices of the two numbers
                return new int[] { map.get(complement), i };
            }
            
            // If not, store the current number and its index in the map
            map.put(nums[i], i);
        }
        
        // Return an empty array in case no solution is found (this shouldn't happen as per the problem description)
        return new int[] {};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]); // Output: [0, 1]
        
        // Example 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Indices: " + result2[0] + ", " + result2[1]); // Output: [1, 2]
        
        // Example 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Indices: " + result3[0] + ", " + result3[1]); // Output: [0, 1]
    }
}
