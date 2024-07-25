// Time Complexity : O(MxN)
// Space Complexity : O(MxN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;  // Get the number of rows in the grid
        int cols = grid[0].length;  // Get the number of columns in the grid
        int result = 0;  // Initialize the result to store the number of islands
        int[][] dirs = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };  // Define the directions for exploring neighboring cells
        Queue<int[]> que = new LinkedList<>();  // Initialize a queue for BFS
        
        // Loop through each cell in the grid
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // If the cell contains '1', it means it's part of an island
                if (grid[row][col] == '1') {
                    que.add(new int[] { row, col });  // Add the current cell to the queue
                    grid[row][col] = '0';  // Mark the cell as visited by setting it to '0'
                    
                    // Process the queue using BFS to explore the entire island
                    while (!que.isEmpty()) {
                        int[] currentCell = que.poll();  // Get the current cell from the queue
                        
                        // Check all four possible directions (up, down, left, right)
                        for (int[] dir : dirs) {
                            int currentRow = currentCell[0] + dir[0];  // Calculate the new row index
                            int currentCol = currentCell[1] + dir[1];  // Calculate the new column index
                            
                            // Check if the new cell is within bounds and is part of the island
                            if ((currentRow >= 0 && currentRow < rows) && (currentCol >= 0 && currentCol < cols)
                                    && grid[currentRow][currentCol] == '1') {
                                grid[currentRow][currentCol] = '0';  // Mark the new cell as visited
                                que.add(new int[] { currentRow, currentCol });  // Add the new cell to the queue
                            }
                        }
                    }
                    result++;  // Increment the island count after exploring the entire island
                }
            }
        }
        return result;  // Return the total number of islands found
    }
}
