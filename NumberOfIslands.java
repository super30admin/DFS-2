// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Iterate the matrix and run dfs; during dfs mark nodes as visited.\
// each complete dfs means that one island is traversed.

class NumberOfIslands {
    int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != '1') {
            return;
        }

        // visited
        grid[row][col] = '0';

        for (int[] dir : dirs) {
            dfs(grid, row + dir[0], col + dir[1]);
        }
    }
}