// Time Complexity : O(m * n), where m is the number of rows and n is the number of columns in the grid.
// Space Complexity : O(m * n) in the worst case due to recursive DFS call stack.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int numIslands(char[][] grid) {

        int rowsLen = grid.length;
        int columnsLen = grid[0].length;
        int result = 0;

        // Traverse the grid cell by cell
        for(int row = 0; row < rowsLen; row++){
            for(int column = 0; column < columnsLen; column++){
                // If land ('1') is found, start DFS to sink the island
                if(grid[row][column] == '1'){
                    result +=1; // Count this island
                    dfs(grid, row, column); // Sink all connected land
                }
            }
        }
        return result;
    }

    // Depth-first search to explore and mark visited land
    public void dfs(char[][] grids, int row, int column){
        int rowsLen = grids.length;
        int columnsLen = grids[0].length;

        // Check boundaries and if current cell is already visited or water
        if(row < 0 || column < 0 || row >= rowsLen || column >= columnsLen || grids[row][column] == '0'){
            return;
        }

        grids[row][column] = '0'; // Mark the current land cell as visited (sink it)

        // Explore all four directions
        dfs(grids, row - 1, column); // up
        dfs(grids, row + 1, column); // down
        dfs(grids, row, column - 1); // left
        dfs(grids, row, column + 1); // right
    }
}
