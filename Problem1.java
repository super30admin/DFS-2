// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : YES
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int num = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    public void bfs(char[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        grid[i][j] = '-';
        q.add(new int[] { i, j });

        int dirs[][] = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        while (!q.isEmpty()) {
            int coord[] = q.poll();
            for (int dir[] : dirs) {
                int x = coord[0] + dir[0];
                int y = coord[1] + dir[1];
                if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1') {
                    grid[x][y] = '-';
                    q.add(new int[] { x, y });
                }
            }
        }
    }
}
