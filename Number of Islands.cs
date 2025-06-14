/*
  Time complexity: O(m*n)
  Space complexity: O(m*n)

  Code ran successfully on Leetcode: Yes
*/

public class Solution {
    public int NumIslands(char[][] grid) {
        if(grid == null || grid.Length == 0)
            return 0;
        int numIslands = 0;
        for(int i = 0; i < grid.Length; i++)
        {
            for(int j = 0; j < grid[0].Length; j++)
            {
                if(grid[i][j] == '1')
                {
                    numIslands += DepthFirstSearch(grid, i, j);
                }
            }
        }
        
        return numIslands;
    }
    
    private int DepthFirstSearch(char[][] grid, int i, int j)
    {
        if(i < 0 || i >= grid.Length || j < 0 || j >= grid[0].Length || grid[i][j] == '0' || grid[i][j] == 'v')
        {
            return 0;
        }
        
        grid[i][j] = 'v';
        
        DepthFirstSearch(grid, i-1, j);
        DepthFirstSearch(grid, i+1, j);
        DepthFirstSearch(grid, i, j-1);
        DepthFirstSearch(grid, i, j+1);
        
        return 1;
        
    }
}
