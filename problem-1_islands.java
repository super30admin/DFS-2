// Time Complexity :
//      m - number of rows
//      n - number of columns
//      total time complexity will be O(m*n)
//
// Space Complexity :
//      O(m+n)->n is number of columns. m is rows. Asymptotically it is linear space.
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null)
            return 0;
        int island = 0;
        //island is number of islands
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                if(grid[i][j]=='1')
                {
                    island++;
                    //calling dfs function to see the adjacent vertical and horizontol cells
                    dfs(grid,  i,  j);
                }
            }
        }
        return island;
    }
    public void dfs(char[][] grid, int i, int j)
    {
        if(i < 0 || i >= grid.length || j<0 || j >= grid[i].length || grid[i][j]=='0')
            return;
        //let us make the visited cells to 0 which initially had 1  
        grid[i][j]='0';
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
   }
}