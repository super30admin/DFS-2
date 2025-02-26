// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// BFS approach with Queue

class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, dirs);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c, int[][] dirs) {
        // base
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == '0') return;

        //logic
        grid[r][c] = '0';
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(grid, nr, nc, dirs);
        }
    }
}