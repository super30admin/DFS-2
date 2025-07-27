// Time Complexity : O(m*n) where m is number of rows and n is number of columns
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem1 (https://leetcode.com/problems/number-of-islands/)
// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

// Example 1:
// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1

// Example 2:
// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3

// Constraints:
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] is '0' or '1'.

class Solution {
    int m, n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        // Edge case check
        if (grid == null || grid.length == 0){
            return 0;
        }

        m = grid.length;
        n = grid[0].length;
        int count = 0;

        // Directions for moving Up, Down, Left, Right
        dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // U D L R

        // Iterate through every cell in the grid
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                // When a '1' is found, it indicates a new island
                if (grid[i][j] == '1'){
                    count++; // Increment island count
                    dfs(grid, i, j); // Mark all connected land using DFS
                }
            }
        }
        return count; // Total number of islands found
    }

    private void dfs(char[][] grid, int row, int col){
        // BASE CASE: If out of bounds or not land ('1'), return
        if (row < 0 || row == m || col < 0 || col == n || grid[row][col] != '1'){
                return;              
        }

        // LOGIC

        // Mark the current land cell as visited (e.g., '2')
        grid[row][col] = '2';

        // Visit all 4 adjacent directions
        for (int[] dir : dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];

            dfs(grid, nr, nc);
        }
    }
}