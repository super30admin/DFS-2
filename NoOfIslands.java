class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int cnt = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == '1') {
                    cnt++;
                    fillIslandDFS(grid, r, c); 
                }
            }
        }
        return cnt;
    }

    private void fillIslandDFS(char[][] grid, int r,int c) {
        if(r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == '0') return;
        grid[r][c] = '0';
        fillIslandDFS(grid, r ,c-1);
        fillIslandDFS(grid, r, c+1);
        fillIslandDFS(grid, r+1, c);
        fillIslandDFS(grid, r-1, c);
    }
} 
