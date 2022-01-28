import java.util.*;

// Time Complexity : O(m*n) where m is the length of row and n is the length of column
// Space Complexity : O(Min(m.n)) where m is the length of row and n is the length of column
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    int[][] dirs;
    int count;

    public int numIslands(char[][] grid) {
        // base
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        // checking in all four directions
        dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Queue<int[]> q = new LinkedList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // check dfs for each one found till the cycle breaks and coutn as 1 island.
                if (grid[i][j] == '1') {
                    count++;
                    // bfs
                    q.add(new int[] { i, j });
                    // make it 0 after addign to q
                    grid[i][j] = '0';
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        for (int[] dir : dirs) {
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1') {
                                q.add(new int[] { r, c });
                                // make it 0 after addign to q
                                grid[r][c] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

}