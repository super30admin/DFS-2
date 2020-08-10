class NUmberOfIslands{
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length == 0){
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;

        int islands = 0;
        for(int i =0;i< r;i++ ){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    _dfs(grid,i,j);
                }
            }
        }
        return islands;

    }

    private void _dfs(char[][] grid,int r,int c){

        if(r>=0 && c>=0 && r< grid.length && c< grid[0].length && grid[r][c]=='1'){
            grid[r][c]='0';
            _dfs(grid,r+1,c);
            _dfs(grid,r-1,c);
            _dfs(grid,r,c+1);
            _dfs(grid,r,c-1);

        }
    }
}