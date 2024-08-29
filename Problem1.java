// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Traverse through every cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If a '1' is found, it's the start of a new island
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);  // Perform DFS to mark the entire island
                }
            }
        }
        
        return numIslands;
    }
    
    // Helper method to perform DFS
    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Base condition to stop DFS
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == '0') {
            return;
        }
        
        // Mark the current cell as visited
        grid[row][col] = '0';
        
        // Explore all 4 directions
        dfs(grid, row + 1, col); // Down
        dfs(grid, row - 1, col); // Up
        dfs(grid, row, col + 1); // Right
        dfs(grid, row, col - 1); // Left
    }
}
