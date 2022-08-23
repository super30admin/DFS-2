class Solution {
    int[][] dirs;
    int m; int n;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        m =grid.length;
        n = grid[0].length;
        int cnt = 0;
        dirs = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(grid[r][c] == '1') {
                    cnt++;
                    fillIslandDFS(grid, r, c); 
                }
            }
        }
        return cnt;
    }

    private void fillIslandDFS(char[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r == m || c == n || grid[r][c] == '0') return;
        grid[r][c] = '0';
        for(int[] dir: dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            fillIslandDFS(grid, nr, nc);
        }
    }
} 
