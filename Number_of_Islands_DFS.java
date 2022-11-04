// TC : O(m*n)
// SC : O(m*n)
// DFS

class Solution {
    int[][] dirs;
    private boolean check(int m, int n, int nr, int nc) {

        if(nr < m && nr >=0 && nc < n && nc >= 0)
            return true;

        return false;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n) {

        for(int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(check(m, n, nr, nc) && grid[nr][nc] == '1') {
                grid[nr][nc] = '0';
                dfs(grid, nr, nc, m, n);
            }
        }
    }

    public int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;

        dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        Queue<int[]> q = new LinkedList<>();
        int result = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return result;
    }
}
