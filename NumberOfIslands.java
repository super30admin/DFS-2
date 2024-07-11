// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*class Solution {
    int m,n;
    int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int numIslands = 0;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == '1') {
                    numIslands++;
                    bfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    void dfs(char[][] grid, int row, int column) {
        // Base
        if(row<0 || row>=m || column<0 || column>=n || grid[row][column] == '0') return;
        // Logic
        grid[row][column] = '0';
        for(int[] dir: dirs) {
            int newX = row + dir[0];
            int newY = column + dir[1];
            dfs(grid, newX, newY);
        }
    }
}*/

class Solution {
  int m,n;
  int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
  public int numIslands(char[][] grid) {
    m = grid.length;
    n = grid[0].length;
    int numIslands = 0;
    Queue<int[]> queue = new LinkedList<>();
    for(int i = 0; i<m; i++) {
      for(int j = 0; j<n; j++) {
        if(grid[i][j] == '1') {
          numIslands++;
          queue.add(new int[]{i,j});
          grid[i][j] = '0';
          while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int column = current[1];
            for(int[] dir: dirs) {
              int newX = row + dir[0];
              int newY = column + dir[1];
              if(newX>=0 && newX<m && newY>=0 && newY<n && grid[newX][newY]=='1') {
                grid[newX][newY] = '0';
                queue.add(new int[] {newX, newY});
              }
            }
          }
        }
      }
    }
    return numIslands;
  }
}