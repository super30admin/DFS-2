// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

public class NumberOfIslands {
    //  DFS Solution

    int[][] dirs;

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;

        dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int count = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        //  base
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == '0')
            return;

        //  logic
        grid[i][j] = '0';

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(grid, x, y);
        }
    }
}
