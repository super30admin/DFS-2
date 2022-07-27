// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int m;
    int n;
    int total = 0;
    int[][] dirs;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    total++; // counts the no. of times DFS is performed==no.of islands.
                    dfs(i, j, grid);
                }
            }
        }
        return total;

    }

    private void dfs(int row, int column, char[][] grid) {
        // base
        if (row < 0 || column < 0 || row == m || column == n || grid[row][column] != '1')
            return;

        // logic
        grid[row][column] = 0; // changing the value of visited cell to avoid visiting it multiple times.
        for (int[] dir : dirs) {
            int nr = dir[0] + row;
            int nc = dir[1] + column;
            dfs(nr, nc, grid);
        }

    }
}