class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int numRows = grid.length;
        int numCols = grid[0].length;
        int count = 0;
        
        // Iterate through each cell in the grid
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                // When we find a land cell
                if (grid[r][c] == '1') {
                    count++; // We found a new island
                    dfs(grid, r, c); // Mark this island as visited using DFS
                }
            }
        }
        
        return count;
    }
    
    // DFS to mark all connected land cells as visited
    private void dfs(char[][] grid, int r, int c) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        
        // Base case: out of bounds or already visited (water or marked land)
        if (r < 0 || c < 0 || r >= numRows || c >= numCols || grid[r][c] != '1') {
            return;
        }
        
        // Mark as visited by changing '1' to '0' (or any other character)
        grid[r][c] = '0';
        
        // Check all four directions
        dfs(grid, r - 1, c); // Up
        dfs(grid, r + 1, c); // Down
        dfs(grid, r, c - 1); // Left
        dfs(grid, r, c + 1); // Right
    }
}
```

The approach uses Depth-First Search (DFS) to solve the problem:

1. Iterate through each cell in the grid.
2. When we encounter a land cell ('1'), we:
   - Increment our island count
   - Use DFS to mark all connected land cells as visited (by changing them to '0')
3. Continue this process for the entire grid.

The time complexity is O(m × n) where m is the number of rows and n is the number of columns, as we visit each cell at most once. The space complexity is O(m × n) in the worst case for the recursion stack if the entire grid is filled with land.

An alternative approach would be to use Breadth-First Search (BFS) or a Union-Find (Disjoint Set) data structure, but the DFS solution is concise and efficient for this problem.