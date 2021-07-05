// Time Complexity : O(m * n)
// Space Complexity : O(m * n)  [dfs call stack]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// We perform dfs for each of the element in the grid and mark it as visited by char 'v'
// In dfs if we encounter '1' then we run further dfs on all of the neighbours to change 1 to visited
class NumberOfIsland {
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int m = 0, n = 0;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        m = grid.length;
        n = grid[0].length;

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        // in bound check
        if (i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == '1') {
            grid[i][j] = 'v';

            for (int[] dir : dirs) {
                dfs(grid, i + dir[0], j + dir[1]);
            }
        }
    }
}