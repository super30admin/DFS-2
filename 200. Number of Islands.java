class Solution {
    int total;
    int [][] dirs;
    int m, n;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        //DFS
        dirs = new int[][]{{-1, 0},{1, 0},{0, 1},{0, -1}};
        m = grid.length;
        n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    total++;
                    dfs(i, j, grid);
                }
            }
        }
        return total;
    }
    
    private void dfs(int r, int c, char[][] grid){
        //BASE
        if(r < 0 || c < 0 || r == m || c == n || grid[r][c] != '1') return;
        
        //LOGIC
        grid[r][c] = '0';
        for(int[] dir : dirs){
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            dfs(nr, nc, grid);
        }
    }
}