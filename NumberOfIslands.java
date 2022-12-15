//problem  : https://leetcode.com/problems/number-of-islands/description/
//https://github.com/PremAmanchi/DFS-2
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : N

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    Island(grid, row, col);
                }
            }
        }
        return count;
    }

    public void Island(char[][] grid, int row, int col) {
        // base case
        if (grid[row][col] == '0') {
            return;
        }
        // all the directions
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int rows = grid.length;
        int cols = grid[0].length;
        // logic
        grid[row][col] = '0';
        for (int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (r >= 0 && r < rows && c >= 0 && c < cols) {
                Island(grid, r, c);
            }
        }
    }
}