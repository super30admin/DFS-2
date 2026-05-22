// Time Complexity : O(m*n)
// Space Complexity : O(m*n) = space consumed by recursion call stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class Solution
{
    private int rows;
    private int columns;
    private int[][] dirs;

    public int NumIslands(char[][] grid)
    {
        rows = grid.Length;
        columns = grid[0].Length;
        dirs = new int[][]
        {
            new int[] {0,1},
            new int[] {0,-1},
            new int[] {1,0},
            new int[] {-1, 0}
        };


        int count = 0;

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                if (grid[i][j] == '1')
                {
                    DFS(grid, i, j);
                    count += 1;
                }
            }
        }

        return count;

    }

    public void DFS(char[][] grid, int i, int j)
    {
        if (i >= 0 && i < rows && j >= 0 && j < columns && grid[i][j] == '1')
        {
            grid[i][j] = '0';

            foreach (int[] dir in dirs)
            {
                DFS(grid, i + dir[0], j + dir[1]);
            }
        }

        return;
    }
}