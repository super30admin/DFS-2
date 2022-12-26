// Time Complexity : O(mn)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Using BFS approach, 
 * Use queue to keep track of the row and col of the matrix and check if the current color is equal to 1 , we add all the indexes in the queue.
 * just go through the next values and change the value from 1 to 0 and increment the count, run till queue is not empty
 */
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dirs = new int[][] { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };

        int count = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    queue.add(new int[] { i, j });

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();

                        for (int[] dir : dirs) {
                            int nr = dir[0] + curr[0];
                            int nc = dir[1] + curr[1];

                            if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0';
                                queue.add(new int[] { nr, nc });
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}

// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Using DFS approach,
 * call the reusrive function when we find 1 and run till we complete all the
 * 1's near by
 */
class Solution {
    private int[][] dirs;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dirs = new int[][] { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };

        int count = 0;

        Queue<int[]> queue = new LinkedList<>();

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

    private void dfs(char[][] grid, int i, int j, int m, int n) {
        // base
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0')
            return;

        // logic
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            dfs(grid, nr, nc, m, n);
        }
    }
}