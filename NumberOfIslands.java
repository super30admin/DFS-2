class NumberOfIslands {
    int[][] dirs;
    int m, n;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int numberOfIslands = 0;
        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        m = grid.length;
        n = grid[0].length;
        for(int i=0;i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    numberOfIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numberOfIslands;
    }

    private void dfs(char[][] grid, int row, int col){
        //base
        if(row<0 || col<0 || row == m || col == n || grid[row][col]!='1'){
            return;
        }

        if(grid[row][col] == '1'){
            grid[row][col] = '2';
        }

        //logic
        for(int[] dir: dirs){
            int nr = dir[0] + row;
            int nc = dir[1] + col;
            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc] == '1'){
                dfs(grid, nr, nc);
            }
        }


    }
}
