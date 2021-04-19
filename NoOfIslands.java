// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here  with comments explaining your approach
class Solution {
  int m, n, count;

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0)
      return 0;

    m = grid.length;
    n = grid[0].length;
    // Have a count variable and increment it when you find 1
    // call a helper method to check its neighbours for 1 too
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          count++;
          helper(grid, i, j);
        }
      }
    }
    return count;
  }

  private void helper(char[][] grid, int row, int col) {
    // base
    // when we find a 0 we return
    if (row < 0 || col < 0 || row == m || col == n || grid[row][col] != '1')
      return;

    // logic
    grid[row][col] = 0;
    int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    // check the neighbours
    for (int[] dir : dirs) {
      int r = row + dir[0];
      int c = col + dir[1];
      helper(grid, r, c);
    }

  }
}