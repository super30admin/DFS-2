//Time = O(m*n), where m is the number of rows and n is the number of columns in the input grid
//Space = O(m*n)

class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0; // Initialize the number of islands to 0
        
        // Iterate through each cell in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') { // If the current cell is part of an island
                    numIslands++; // Increment the number of islands
                    
                    // Mark all cells in this island as visited (i.e., '0')
                    dfs(grid, i, j);
                }
            }
        }
        
        return numIslands; // Return the total number of islands
    }
    
    // DFS function to mark all cells in the current island as visited
    private void dfs(char[][] grid, int i, int j) {
        // Check if the current cell is within the bounds of the grid and part of the island
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return; // If not, return and end the recursion
        }
        
        // Mark the current cell as visited (i.e., set its value to '0')
        grid[i][j] = '0';
        
        // Recursively mark all adjacent cells in the island as visited
        dfs(grid, i + 1, j); // Check the cell below the current cell
        dfs(grid, i - 1, j); // Check the cell above the current cell
        dfs(grid, i, j + 1); // Check the cell to the right of the current cell
        dfs(grid, i, j - 1); // Check the cell to the left of the current cell
    }
}
