// For small to medium size gird, use DFS. If larger, use BFS to avoid stack overflow.
class Solution {
    int[][] dirs = {{-1, 0}, {1,0}, {0, -1}, {0, 1}}; //UDLR
    // BFS
    public int numIslandsBFS(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    count++;
                    q.add(new int[] {i, j});

                    while(!q.isEmpty()) {
                        int[] cur = q.poll();

                        for (int[] dir : dirs) {
                            int nr = cur[0] + dir[0];
                            int nc = cur[1] + dir[1];

                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0';
                                q.add(new int[] {nr, nc});
                            }
                        }
                    }
                }
                
            }
        }

        return count;

    }

    // DFS
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, m, n, i, j);
                }
            }
        }
        return count;

    }

    private void dfs(char[][] grid, int m, int n, int row, int col) {
        if (row < 0 || row == m || col < 0 || col == n || grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '2'; // some char other than 1

        // 4 dir in 4 calls or in for loop are same.
        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            dfs(grid, m, n, nr, nc);
        }
    }
}