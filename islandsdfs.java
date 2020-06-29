//Time Complexity:O(mn)
//Space complexity:O(mn)

class Solution {
    int result;
    int[][] dirs;
    int m;
    int n;
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        m=grid.length;
        n=grid[0].length;
        dirs=new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        result=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    result++;
                    dfs(grid,i,j);
                }
            }
        }
        return result;
    }
    private void dfs(char[][] grid, int r, int c){
        //base
        if(r<0 || c<0 || r>=m || c>=n || grid[r][c]=='2' || grid[r][c]=='0'){
            return;
        }
        //logic
        grid[r][c]='2';
        for(int[] dir:dirs){
            int row=r+dir[0];
            int col=c+dir[1];
            dfs(grid,row,col);
            
        }
    }
}