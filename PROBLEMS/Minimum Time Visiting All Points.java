Explanation:

The goal is to calculate the minimum time required to visit all points in the 2D plane.
The optimal time between two points [x1, y1] and [x2, y2] is determined by the formula max(|x2 - x1|, |y2 - y1|). This is because we can move diagonally when both x and y change, and we can move in straight lines when only one coordinate changes.
We calculate the time between each consecutive point and sum it up.

public class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;
        
        // Iterate through all consecutive points
        for (int i = 1; i < points.length; i++) {
            int x1 = points[i - 1][0];
            int y1 = points[i - 1][1];
            int x2 = points[i][0];
            int y2 = points[i][1];
            
            // Calculate the time to move from (x1, y1) to (x2, y2)
            int time = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
            
            // Add the time to the total
            totalTime += time;
        }
        
        return totalTime;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[][] points1 = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println(solution.minTimeToVisitAllPoints(points1)); // Output: 7

        // Test case 2
        int[][] points2 = {{3, 2}, {-2, 2}};
        System.out.println(solution.minTimeToVisitAllPoints(points2)); // Output: 5
    }
}
Explanation of Logic:

We calculate the time between each pair of consecutive points.
The time taken to move from one point to another is determined by the formula max(|x2 - x1|, |y2 - y1|) because moving diagonally covers both x and y changes.
The total time is the sum of these times for all consecutive points.
This solution works in O(n) time complexity.
