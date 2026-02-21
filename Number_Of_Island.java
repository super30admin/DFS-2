/*
Approach: traverse each cell in the grid. 
When a cell with '1' is found:
 --> increment the count of island
 --> perform DFS to visit all connected cells.
To perform dfs:
 --> stop if the cell is out of bounds or is '0'
 --> mark the cell as visited - 0.
 --> recursively explore all direction
continue unit entire grid is processed.
*/

// Time Complexity : O(mxn)
// Space Complexity : O(mxn)

// The code ran successfully on leetcode


class Solution {
    int m, n;
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        int count = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++; // increment the count if land or island is found.
                    dfs(grid, i, j); // perform dfs
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int r, int c) {
        // boundary + water check
        if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == '0')
            return;
        
        // mark visited
        grid[r][c] = '0';
        
        // explore all 4 directions
        for(int[] dir : dirs) {
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
}