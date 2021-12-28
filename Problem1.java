//number of islands
//sc: o(mn)
//tc: o(mn)
public class Problem1 {
    int m,n,count;
    int[][] dirs ={{-1,0},{0,-1},{1,0},{0,1}};
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return -1;
        }
        m=grid.length;
        n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        
        return count;
    }
    
    private void dfs(int i, int j,char[][] grid){
        if(i>=m || j>=n || i<0 || j< 0 || grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        for(int[] dir : dirs){
            int nr = dir[0]+i;
            int nc=dir[1]+j;
            dfs(nr,nc,grid);
        }
    }
}
