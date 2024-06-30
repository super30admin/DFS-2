// Time Complexity : O(m x n)
// Space Complexity : O(m x n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int m, n;
    int[][] dirs;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // U D L R
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') { // land
                    count++; // keeping counter of number of times we did dfs
                    dfs(grid, i, j); // recursive call
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        // base case
        if (i == m || j == n || i < 0 || j < 0 || grid[i][j] != '1') {
            return;
        }

        // logic
        grid[i][j] = '2'; // to mark it visited
        for (int[] dir : dirs) { // traversing in 4 directions
            int nr = i + dir[0];
            int nc = j + dir[1];
            dfs(grid, nr, nc); // recursion
        }

    }
}
