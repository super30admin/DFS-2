class Solution {
    public int numIslands(char[][] grid) {
        int m=grid[0].length;
        int n=grid.length;
        int count=0;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    grid[i][j]='0';
                    dfs(grid,i,j,m,n,dirs);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j, int m, int n, int[][]dirs){
        for(int[] dir:dirs){
            int nr=i+dir[0];
            int nc=j+dir[1];

            if(nr>=0 && nc>=0 && nc<m && nr<n && grid[nr][nc]=='1'){
                grid[nr][nc]='0';
                dfs(grid,nr,nc,m,n,dirs);
            }
        }
    }
}
