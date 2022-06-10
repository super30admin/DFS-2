class Solution {

    /**
     * BFS-
     * Go over the metrix, find first 1. BFS on that. Mutate all connected one to 0 or 2. Increase island count.
     */
    public int numIslands(char[][] grid) {
        // edge
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    q.add(new int[]{i, j});

                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        for (int[] dir : dirs) {
                            int r = dir[0] + curr[0];
                            int c = dir[1] + curr[1];

                            if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1') {
                                q.add(new int[]{r, c});
                                grid[r][c] = 0;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}

/************************************ DFS ************************************/
int count = 0;
    int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int numIslands(char[][] grid) {
        // edge
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
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

        if (i < 0 || j < 0 || i == m || j == n || grid[i][j] != '1') {
            return;
        }

        //logic
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;
            dfs(grid, r, c, m, n);
        }
    }
}