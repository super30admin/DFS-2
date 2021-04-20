/* Time compl:O(mn)
iterating over the gid getting a count of all the ones andthen calling the
dfs method again.
In the dfs method the base case is checking if the row and column val is out of bound
and also checking value.
then marking the cell visted and then checking its neighbours*/

class Solution {
    int m,n,count;
    public int numIslands(char[][] grid) {
     if(grid==null|| grid.length==0){
         return 0;
     } 
        m=grid.length;
        n=grid[0].length;
        count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid, i,j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][]grid,int r,int c){
        if(r<0 ||r==m || c<0 || c==n || grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dire : dir){
            int row=r+dire[0];
            int col=c+dire[1];
            dfs(grid,row,col);
        }
    }
}