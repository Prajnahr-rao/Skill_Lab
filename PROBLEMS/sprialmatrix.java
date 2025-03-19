
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Define the boundaries
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse right (top row)
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            
            // Traverse down (rightmost column)
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            // Traverse left (bottom row) - check to avoid duplicate row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            // Traverse up (leftmost column) - check to avoid duplicate column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return result;
    }
}
```

The algorithm works as follows:
1. Define four boundary variables: `top`, `bottom`, `left`, and `right`
2. In each iteration of the outer while loop, traverse in four directions:
   - Right: Move along the top row from left to right, then increment `top`
   - Down: Move along the rightmost column from top to bottom, then decrement `right`
   - Left: Move along the bottom row from right to left, then decrement `bottom`
   - Up: Move along the leftmost column from bottom to top, then increment `left`
3. We add additional checks before traversing left and up to handle cases where we might have a single row or column remaining

The time complexity is O(m×n) where m is the number of rows and n is the number of columns, as we visit each element exactly once. The space complexity is O(1) excluding the output array.