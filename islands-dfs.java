//TC is O(mxn)
//SC is O(mxn)
class Solution {
    int dirs[][];
    int m, n;

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;

        m = grid.length;
        n = grid[0].length;
        dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // start dfs
                    count++;

                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        // base
        if (row < 0 || row == m || col < 0 || col == n || grid[row][col] != '1') {
            return;
        }

        // logic
        grid[row][col] = '0';

        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            dfs(grid, nr, nc);
        }
    }
}