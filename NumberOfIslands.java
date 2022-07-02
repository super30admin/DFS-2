/*
This solution uses a DFS approach to solve the problem. We start from the (0,0) location in the grid, and iterate over the
entire grid. Whenever we reach an island i.e reach a 1, we mark the island as found and initiate DFS from that grid location
to traverse the whole area of that island, till we reach the borders i.e reach 0.

Note: The BFS solution is more optimal with space

Did this code run on leetcode: Yes
*/
class Solution {
    //Time Complexity: O(m*n)
    //Space Complexity: O(m*n)
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        //Processing for each element
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {   
                if(grid[i][j] == '1')
                {
                    dfs(grid, i, j, m, n, dirs);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j, int m, int n, int[][] dirs)
    {
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0')
            return;
        //We reset the value after traversing the cell, so that we do not traverse the same node again through another DFS
        grid[i][j] = '0';
        for(int[] dir: dirs)
        {
            int r = dir[0] + i;
            int c = dir[1] + j;
            dfs(grid, r, c, m, n, dirs);
        }
    }
}