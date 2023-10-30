// Time Complexity : O(m*n)
// Space Complexity : o(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution {
    public void dfs(char[][] grid,int i,int j){
        if(i >= grid.length || i<0 || j >= grid[0].length || j<0 || grid[i][j]=='0'){
        return;}
        grid[i][j]='0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        

    }
    public int numIslands(char[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      int count = 0;

      for(int i = 0; i < m; i++){
          for(int j = 0; j < n; j++){
              if(grid[i][j]=='1'){
                  count++;
                  dfs(grid,i,j);
              }
                    
          }
      }
      return count;  
    }
}