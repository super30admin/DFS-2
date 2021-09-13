
/**
Time: O(m*n) where m = rows and n = cols
Space: O(1)
*/
class NumIslands {
    public int numIslands(char[][] grid) {
       int count = 0;

       for (int i = 0; i < grid.length; i++) {
           for (int j = 0; j < grid[i].length; j++) {
               if (grid[i][j] == '1') {
                   // once we see a 1 we know that we have seen an island, now DFS to see how
                   // long the island spans out
                   count++;
                   dfs(grid, i, j);
               }
           }
       }
       return count;

   }

   public void dfs(char[][] grid, int i, int j) {
       // check boundaries
       if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
           return;

       grid[i][j] = '0'; // mark all visited 1s to 0s because we visit a value only once. We don't need
                         // it again.

       dfs(grid, i - 1, j);// up
       dfs(grid, i + 1, j);// down
       dfs(grid, i, j - 1);// left
       dfs(grid, i, j + 1);// right
   }
}