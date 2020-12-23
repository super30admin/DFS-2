/**
 * Time Complexity = O(M x N)
 * Space Complexity = O(M x N)
 * LeetCode: Y(https://leetcode.com/problems/number-of-islands)
 * Approach: 
 *    Do the DFS to mark all pieces of land of an island as visited as they are part of the same island
 *    Traverse the grid, perform a DFS when you see a piece of land,
 *    When you see a piece of land mark the land as visited
 *    Do this for all the islands
 */

class Solution {
    public int numIslands(char[][] grid) {
        // variable to track number of islands
        int numberOfIslands = 0;
        
        // 2d matrix to track the land pieces already considered as a part of some island
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        // Loop through the grid
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[0].length ; j++) {
                // if there is a piece of land that is not visited then increment numberOfIslands and perform DFS on its neighboring cells
                if(grid[i][j] == '1' && !visited[i][j]) {
                    // increment numberOfIslands
                    numberOfIslands++;
                    
                    // perform DFS on its neighboring cells
                    doDFSUtil(grid, i, j, visited);
                }
            }
        }
        
        return numberOfIslands;
    }
    
    /* Helper function to perform DFS */
    private void doDFSUtil(char[][] grid, int row, int col, boolean[][] visited) {
        
        // if the grid position is not valid or the grid position is water or the grid position is land already seen
        if(!isGridPositionValid(row, col, grid.length, grid[0].length) || grid[row][col] == '0' || visited[row][col]) {
            return;
        }
        
        // mark the current piece of land as visited
        visited[row][col] = true;
        
        // / dirs array to look in the 4 neighboring grid positions
        int[] dirs = {-1, 0, 1, 0, -1};

        // Look in all 4 directions
        for(int i = 0 ; i < 4 ; i++) {
            // get row number of neighboring cell position
            int neighborRow = row + dirs[i];
            
            // get col number of neighboring cell position
            int neighborCol = col + dirs[i + 1];
            
            // Explore neighboring grid position with DFS
            doDFSUtil(grid, neighborRow, neighborCol, visited);
        }
    }
    
     /* Helper function to check if the current pixel is within the dimensions of the matrix */
    private boolean isGridPositionValid(int row, int col, int rows, int cols) {
        return (row >= 0 && row < rows && col >= 0 && col < cols);
    }
}
