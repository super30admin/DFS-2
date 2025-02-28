// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j, dirs, m, n);
                }
            }
        }
        return cnt;
    }

    private void dfs(char[][] grid, int i, int j, int[][] dirs, int m, int n) {

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0')
            return;

        grid[i][j] = '0';

        for (int[] dir : dirs) {
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            dfs(grid, nr, nc, dirs, m, n);
        }
    }
}