// Time Complexity : O(n * m) [n: num of cols; m: number of rows]
// Space Complexity : O(m * n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int m;
    int n;
    int[][] dirs;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        // return helperBfs(grid);
        return helperDfs(grid);
    }

    private int helperDfs(char[][] grid) {
        char zero = '0';
        char one = '1';
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == one) {
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }

        return cnt;
    }

    private void dfs(char[][] grid, int r, int c) {
        char zero = '0';
        char one = '1';
        if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == zero) {
            return;
        }

        grid[r][c] = zero;
        for(int [] dir: dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(grid, nr, nc);
        }
    }

    // Space Complexity : O(min(m,n))
    private int helperBfs(char[][] grid) {
        char zero = '0';
        char one = '1';
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == one) {
                    cnt++;
                    q.offer(i);
                    q.offer(j);
                    grid[i][j] = zero;
                    while (!q.isEmpty()) {
                        int cr = q.poll();
                        int cc = q.poll();
                        for (int[] dir : dirs) {
                            int nr = cr + dir[0];
                            int nc = cc + dir[1];

                            if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == one) {
                                q.offer(nr);
                                q.offer(nc);
                                grid[nr][nc] = zero;
                            }
                        }
                    }
                }
            }
        }

        return cnt;
    }
}