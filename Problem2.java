
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// calculates the number of distinct islands in a given grid by employing depth-first search (DFS)
// traversal to mark and count connected components represented by '1's.
// note this is 1st problem - numIslands
class Problem2 {
    int m, n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row == m || col < 0 || col == n || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '2';
        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            dfs(grid, nr, nc);
        }
    }
}