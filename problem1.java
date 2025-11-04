// Time Complexity : O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :yes

/*
 * Approach
 * Basic idea to solve the problem is to itterate over the grid,
 * whenever we find "1", increase the island count by 1 and change the connected 1 to zero 
 * so we don't count them a second time
 * 
 *  when are find a "1" we start the dfs from that point
 * to find out all the connected "1" to make them zero
 * 
 * to find the connected "1" we use the dirs array. 
 * 
 */

class Solution {
    public int numIslands(char[][] grid) {
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
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

    private void dfs(char[][] grid, int i, int j, int dirs[][]) {
        // base
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == '0')
            return;

        // logic
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            dfs(grid, nr, nc, dirs);
        }

    }
}