// https://leetcode.com/problems/number-of-islands/

// Time Complexity: O(m * n)
// Space Complexity: O(Mim of (m, n))
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Took reference from lecture

// ---------------------------- BFS --------------------------------------
class Solution {
    public int numIslands(char[][] grid) {
        int output = 0;
        if (grid == null)
            return -1;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    output++;
                    q.offer(new int[] { i, j });
                    grid[i][j] = '0';

                    while (!q.isEmpty()) {
                        int[] curr = q.poll();

                        for (int[] dir : dirs) {
                            int nr = dir[0] + curr[0];
                            int nc = dir[1] + curr[1];

                            // Check bounds
                            if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
                                q.offer(new int[] { nr, nc });
                                grid[nr][nc] = '0';
                            }

                        }
                    }
                }
            }
        }

        return output;

    }
}