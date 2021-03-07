/**
 * Time Complexity = O(M x N)
 * Space Complexity = O(min(M,N))
 * LeetCode: Y(https://leetcode.com/problems/number-of-islands)
 * Approach: 
 *    Do the BFS to mark all pieces of land of an island as visited as they are part of the same island
 *    Traverse the grid, perform a BFS when you see a piece of land,
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
                // if there is a piece of land that is not visited then increment numberOfIslands and perform BFS on its neighboring cells
                if(grid[i][j] == '1' && !visited[i][j]) {
                    // increment numberOfIslands
                    numberOfIslands++;
                    
                    // perform BFS on its neighboring cells
                    doBFSUtil(grid, i, j, visited);
                }
            }
        }
        return numberOfIslands;
    }
    
    /* Helper function to perform BFS */
    private void doBFSUtil(char[][] grid, int row, int col, boolean[][] visited) {
        
        // initialize queue to perform BFS from grid[row][col]
        Queue<Integer> q = new LinkedList<Integer>();
        
        // get total number of columns in the grid
        int numOfCols = grid[0].length;
        
        // mark the current piece of land as visited
        visited[row][col] = true;
        
        // enqueue source grid position
        q.add(row * numOfCols + col);
        
        // loop until all the adjacent land pieces are visited
        while(!q.isEmpty()) {
            // get the current cell from front of queue
            int currentCell = q.poll();
            
            // extract row number of current cell
            int currentRow = currentCell / numOfCols;
            
            // extract col number of current cell
            int currentCol = currentCell % numOfCols;
            
            // dirs array to look in the 4 neighboring grid positions
            int[] dirs = {-1, 0, 1, 0, -1};

            // Look in all 4 directions
            for(int i = 0 ; i < 4 ; i++) {
                // get row number of neighboring cell position
                int neighborRow = currentRow + dirs[i];

                // get col number of neighboring cell position
                int neighborCol = currentCol + dirs[i + 1];

                // check if the neighboring grid position is valid and neighboring grid position is land not visited 
                if(isGridPositionValid(neighborRow, neighborCol, grid.length, grid[0].length) && grid[neighborRow][neighborCol] == '1' && !visited[neighborRow][neighborCol]) {
                    // mark the land piece as visited
                    visited[neighborRow][neighborCol] = true;
                    // enqueue the grid position
                    q.add(neighborRow * numOfCols + neighborCol);
                }
            }
        }
    }
    
     /* Helper function to check if the current pixel is within the dimensions of the matrix */
    private boolean isGridPositionValid(int row, int col, int rows, int cols) {
        return (row >= 0 && row < rows && col >= 0 && col < cols);
    }
}
