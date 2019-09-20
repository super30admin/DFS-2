/**
 * LeetCode Execution: Smooth ! 
 * 
 * Time Complexity:  O(r * c) r-> Rows; c -> Columns
 * Space Complexity: O(r * c) For the Recursion Stack
 * 
 * Appraoch: Find a land and from that start traversing and changing the values of visited land. Number of times the main function call traverse function will be our count
 * 
 * Personal Note:
 * I had solved this problem 5 months ago, this time when I tried my approach was so much clear with a consise code.
 */

class Solution {
  int[][] dir = {{1,0}, {0,1}, {-1, 0}, {0,-1}};
  
  public int numIslands(char[][] grid) {
      
      int count = 0;
      
      for (int i = 0; i < grid.length; i++) {
          for (int j = 0; j < grid[0].length; j++) {
              if (grid[i][j] == '1') {
                  grid[i][j] = '*';
                  count++;
                  traverseHelper(grid, i, j);
              }
          }
      }
      
      return count;        
  }
  
  private void traverseHelper(char[][] grid, int r, int c) {
      
      for (int[] d : dir) {
          int nr = r + d[0];
          int nc = c + d[1];
          
          if (0 <= nr && nr <grid.length && 0 <= nc && nc < grid[0].length && grid[nr][nc] == '1') {
              grid[nr][nc] = '*';
              traverseHelper(grid, nr, nc);
          }
      }
      
  }
}