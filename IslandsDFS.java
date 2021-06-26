// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package dfs2;

import java.util.*;

public class IslandsDFS {

    int dirs[][];
    int count;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> c = new LinkedList<>();
        dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length, n = grid[0].length, count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c, int m, int n) {
        if (r < 0 || c < 0 || r == m || c == n || grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '0';
        for (int dir[] : dirs) {
            int i = r + dir[0];
            int j = c + dir[1];
            dfs(grid, i, j, m, n);
        }

    }
}
