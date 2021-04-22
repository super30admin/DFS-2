// Time Complexity : O(mn) where m is th e number of rows and n is the number of columns
// Space Complexity : O(mn) where m is th e number of rows and n is the number of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;    
        
        int cnt =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    cnt++;
                    dfs(i,j,grid);
                }
            }
        }
        return cnt;
    }
    
    public void dfs(int i, int j, char[][]grid){
        if(i<0 || i>=grid.length || j<0 || j >=grid[0].length || grid[i][j] == '0')
            return;
        
        grid[i][j] = '0';
        
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }
}