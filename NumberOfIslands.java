// Time Complexity : O(NxM)N=number of rows in matrix and M number of columns in matrix . 
// Space Complexity : O(maxDepth) for space, O(n/2) then O(N);
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//the code uses the DFS traversal and we only execute DFS is the field is == 1. so to mark something visited we change it to 'v'.
//Success
//Details 
//Runtime: 1 ms, faster than 99.95% of Java online submissions for Number of Islands.
//Memory Usage: 42 MB, less than 44.19% of Java online submissions for Number of Islands.

//O(NxM) for time
    //O(maxDepth) for space, O(n/2) then O(N);
    public int numIslands(char[][] grid) {
      int numIslands=0;
      for (int i=0;i< grid.length;i++){
         for (int j=0;j<grid[0].length;j++){
             if (grid[i][j]=='1'){
                 numIslands++;
                 dfs(i,j,grid);
             }
         }

      }
      return numIslands;
    }

    public void dfs(int row, int col,char[][] grid){
      if (row <0 || row >= grid.length || col<0 || col>=grid[0].length || grid[row][col]!='1')
          return;
      grid[row][col]='v';
      dfs(row-1,col,grid);
      dfs(row+1,col,grid);
      dfs(row,col-1,grid);
      dfs(row,col+1,grid);
    }
}