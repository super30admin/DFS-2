// // BFS
// // TC: O(m*n)-> m, n : dimensions of the grid
// // SC: O(min(m,n))
// // Did it run successfully on Leetcode? : Yes
// class Solution {
//     public int numIslands(char[][] grid) {
//     if ( grid == null || grid.length == 0)
//         return 0;
//      int m = grid.length;
//      int n = grid[0].length;
//      int numOfIslands = 0;
//      int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
//      Queue<int[]> q = new LinkedList();
//      for ( int i = 0; i < m; i++)
//      {
//          for ( int j = 0; j < n; j++)
//          {
//              if (grid[i][j] == '1')
//              {
//                  q.add(new int[]{i, j});
//                  grid[i][j] = '0';
//                  numOfIslands++;
//                  while (!q.isEmpty())
//                  {
//                     int[] cur = q.poll();
//                     for (int[] dir : dirs)
//                     {
//                         int r = cur[0] + dir[0];
//                         int c = cur[1] + dir[1];
//                         if (r < m && c < n && r >=0 && c >=0 && grid[r][c] == '1')            
//                          { 
//                             q.offer(new int[]{r,c});
//                             grid[r][c] = '0';
//                          }
//                      }
//                  }
//               }
//          }
//      }
//      return numOfIslands;   
//     }
// }


// DFS 1
// TC: O(m*n)-> m, n : dimensions of the grid
// SC: O(m*n)-> m, n : dimensions of the grid
// Did it run successfully on Leetcode? : Yes
class Solution {
    int m, n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
      int numOfIslands = 0;
      m = grid.length;
      n = grid[0].length;
      dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
      for ( int i = 0; i < grid.length; i++){
          for (int j = 0; j < grid[i].length; j++)
          {
              if (grid[i][j] == '1')
              {
                  numOfIslands++;
                  dfs(grid, i ,j);
              }
          }        
      } 
        return numOfIslands;
    }
    private void dfs(char[][] grid, int i, int j)
    {
      if ( i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        for (int[] dir: dirs)
        {
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, r, c);
        } 
    }
}

// DFS 2
// TC: O(m*n)-> m, n : dimensions of the grid
// SC: O(m*n)-> m, n : dimensions of the grid
// Did it run successfully on Leetcode? : Yes
// class Solution {
//     public int numIslands(char[][] grid) {
//       int numOfIslands = 0;
//       for ( int i = 0; i < grid.length; i++){
//           for (int j = 0; j < grid[i].length; j++)
//           {
//               if (grid[i][j] == '1')
//               {
//                   numOfIslands = numOfIslands + dfs(grid, i ,j);
//               }
//           }        
//       } 
//         return numOfIslands;
//     }
//     public int dfs(char[][] grid, int i, int j)
//     {
//       if ( i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
//             return 0;
//         grid[i][j] = '0';
//         dfs(grid, i+1, j); //down
//         dfs(grid, i, j+1); //right
//         dfs(grid, i-1, j); //up
//         dfs(grid, i, j-1); //left
//         return 1; // to account for the grid which is 1 in the numIslands function
//     }
// }
