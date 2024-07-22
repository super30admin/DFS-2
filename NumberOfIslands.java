// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Using BFS
class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count = count + 1;
                    q.add(new int[] { i, j});
                    grid[i][j] = '0'; // converting firs '1' to 0

                    while (!q.isEmpty()) {
                        int[] currentElement = q.poll();
                        // check for neighbors
                        for (int[] dir : dirs) {
                            int nr = currentElement[0] + dir[0];
                            int nc = currentElement[1] + dir[1];

                            // boundary check
                            if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
                                grid[nr][nc] = 0;
                                q.add(new int[] { nr, nc });
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}

// Using DFS
class NumberOfIslands {
    // Using DFS
    int count;

    public int numIslands(char[][] grid) {
        this.count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count = count + 1;
                    dfs(grid, i, j, dirs);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c, int[][] dirs) {
        // base
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == '0')
            return;
        // logic
        grid[r][c] = '0';
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(grid, nr, nc, dirs);
        }
    }
}