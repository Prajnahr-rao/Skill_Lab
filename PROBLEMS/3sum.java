Key Points for 3Sum Problem (Java)
Sort the Array → Helps with duplicate handling and two-pointer search.
Fix One Element (nums[i]) → Use a loop to pick the first number.
Use Two Pointers (left, right)
If sum < 0 → Move left++
If sum > 0 → Move right--
If sum == 0 → Store the triplet and skip duplicates.
Skip Duplicates → Avoid repeated triplets.
Time Complexity: O(n²) → Optimal for this problem.

Example Walkthrough
Input:
nums = [-1, 0, 1, 2, -1, -4];
Sorted:
[-4, -1, -1, 0, 1, 2]
Triplets Found:
[[-1, -1, 2], [-1, 0, 1]]

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) left++;
                else right--;
            }
        }
        return result;
    }
}

