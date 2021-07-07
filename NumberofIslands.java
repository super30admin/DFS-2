class NumberOfIslands{
    // BFS - Time: 2(m*n)
    //       Space: min(m,n)

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> q= new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    q.add(new int[]{i,j});
                    count++;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        for(int[] dir:dirs){
                            int nr = dir[0] + cur[0];
                            int nc = dir[1] + cur[1];
                            if(nr >=0 && nc >= 0 && nr< m && nc < n && grid[nr][nc]=='1'){
                                q.add(new int[]{nr,nc});
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    // DFS - Time: 2(m*n)
    //       Space: min(m,n)
    int[][] dirs;
    int count;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n){
        //base
        if(i <0 || j <0 || i== m || j == n || grid[i][j]!='1') return;
        //logic
        grid[i][j] = '0';
        for(int[] dir:dirs){
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            dfs(grid, nr, nc, m ,n);
        }
    }
}