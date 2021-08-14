// DFS
class Solution {
    int m, n;
    int count = 0;
    int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '#';
        for(int[] d : dirs) {
            int r = i + d[0];
            int c = j + d[1];
            dfs(grid, r, c);
        }
    }
}