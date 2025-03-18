Explanation:

This problem requires us to find for each number in the array how many numbers are smaller than it.
We sort the array, and for each number in the sorted array, its index represents how many smaller elements exist before it.
We store this information in a map for efficient lookup.
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        // Create a sorted copy of the nums array
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        
        // Map to store how many numbers are smaller than each number
        Map<Integer, Integer> map = new HashMap<>();
        
        // Fill the map with the count of smaller numbers for each unique number
        for (int i = 0; i < n; i++) {
            // If the number is not in the map, it's its first appearance, so map it to its index in the sorted array
            if (!map.containsKey(sortedNums[i])) {
                map.put(sortedNums[i], i);
            }
        }
        
        // Create an array to store the result
        int[] result = new int[n];
        
        // For each number in the original array, get the count of smaller numbers from the map
        for (int i = 0; i < n; i++) {
            result[i] = map.get(nums[i]);
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {8, 1, 2, 2, 3};
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(nums1))); // Output: [4, 0, 1, 1, 3]

        // Example 2
        int[] nums2 = {6, 5, 4, 8};
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(nums2))); // Output: [2, 1, 0, 3]

        // Example 3
        int[] nums3 = {7, 7, 7, 7};
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(nums3))); // Output: [0, 0, 0, 0]
    }
}

Explanation of Logic:

Sort the array nums and create a copy of it (sortedNums).
We use a HashMap to store the smallest element's index. The key is the number, and the value is the index in the sorted array.
For each element in the original array, we use the map to get how many numbers are smaller than it (its index in the sorted array).
This approach gives a time complexity of O(n log n) due to sorting, with O(n) additional operations for the map.