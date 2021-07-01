//Time Complexity - (m*n)
//Space Complexity - O(min(m,n))

class Solution {
    int [][] dirs;
    public int numIslands(char[][] grid) {
      if(grid == null || grid.length == 0) {
          return 0;
      }
      
      int m = grid.length; int n = grid[0].length;
       dirs = new int [][] {{0,1},{0,-1},{-1,0},{1,0}};
      int count = 0;
      for(int i = 0; i< m; i++) {
        for(int j = 0; j< n ;j ++) {
          if(grid[i][j] == '1') {
            //count no of island when one is encountered and call dfs 
            // trevaerse neighbouring element
            count ++;
            dfs(grid, i, j, m, n);
          }
        }
      }
      return count;
    }
  
  private void dfs(char[][] grid, int r, int c, int m, int n) {
    //base
    if(r < 0 || c < 0 || r == m || c==n || grid[r][c] != '1') {
      return;
    }
    //logic
    //if element is 1 then update it to 0(mark visited)
    grid[r][c] = '0';
    for(int[] dir: dirs) {
      int i = r+dir[0];
      int j = c+dir[1];
      dfs(grid,i,j,m,n);
    }
  }
}