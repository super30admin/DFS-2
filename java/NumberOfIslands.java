// Time Complexity : O(mxn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Find 1 and then do recursive dfs on all 4 directions and add 1 to the count.
 */
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int numIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j, m, n);
                }
            }

        }
        return numIslands;

    }

    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private void dfs(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, r, c, m, n);
        }

    }
}

Approach 2---BFS-------------------------------------------------------
// Time Complexity : O(mn)
// Space Complexity :O(Min(mn))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
BFS
 */
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int numIslands = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    queue.add(new int[]{i, j});
                }
                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    for (int[] dir : dirs) {
                        int row = curr[0] + dir[0];
                        int col = curr[1] + dir[1];
                        if (row >= 0 && col >= 0 && row < m && col < n && grid[row][col] == '1') {
                            grid[row][col] = '0';
                            queue.add(new int[]{row, col});

                        }
                    }

                }
            }
        }
        return numIslands;

    }
}