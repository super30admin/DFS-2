class Solution {
    int[] dirs = { -1, 0, 1, 0, -1 };
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int r = grid.length;
        int c = grid[0].length;
        int numIslands = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    bfs(grid, i, j, r, c);
                }
            }
        }
        return numIslands;
    }

    private void bfs(char[][] grid, int x, int y, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { x, y });
        grid[x][y] = '0';

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int currX = cell[0];
            int currY = cell[1];

            for (int i = 0; i < 4; i++) {
                int nx = currX + dirs[i];
                int ny = currY + dirs[i + 1];

                if(nx>=0 && nx<r && ny >= 0 && ny<c && grid[nx][ny] == '1'){
                    grid[nx][ny] = '0';
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
// Time Complexity: O(M * N) -> Each cell is visited once in DFS/BFS.
// Space Complexity: O(M * N) -> Stack (DFS) or queue (BFS) can store at most M * N cells in the worst case.
