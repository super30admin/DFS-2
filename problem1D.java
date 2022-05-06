class numberOfIslands1{
    int m, n, total;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        m = grid.length;
        n = grid[0].length;
        total = 0;
        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    total++;
                    dfs(grid, i, j);
                }
            }
        }
        return total;
    }

    private void dfs(char[][] grid, int r, int c){
        if(r < 0 || r == m || c < 0 || c == n || grid[r][c] != '1'){
            return;
        }
        grid[r][c] ='0';

        for(int[] dir : dirs){
            int rn = dir[0] + r;
            int cn = dir[1] + c;
            dfs(grid, rn, cn);
        }
    }
}

// time complexity O(m*n)
//space complexity O(m*n)