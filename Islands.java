class Solution {
    int m,n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        this.dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int count=0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
              if(grid[i][j]=='1'){
                  count++;
                  dfs(grid,i,j);
              }
            }
        }
        
        return count;
    }
    
    
    private void dfs(char[][] grid,int i,int j){
        if(i<0 || j<0 || i==m || j==n || grid[i][j]!='1') return;
        
        
        grid[i][j]='0';
        for(int[] dir:dirs){
            int r=dir[0]+i;
            int c=dir[1]+j;
            dfs(grid,r,c);
        }
    }
}