// Time Complexity : O(m*n)we are traversing through the entire matrix so, the TC will be size of the matrix.
// Space Complexity : O(m*n) auxiliary stack space due to recursion.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    private void Island(char[][] grid, int row, int col)
    {
        grid[row][col] = 0;
        int[] x = new int[]{-1, 0, 1, 0};
        int[] y = new int[]{0, 1, 0, -1};

        for(int i=0, j=0; i<x.length && j<y.length; i++, j++)
        {
                int newrow = row+x[i];
                int newcol = col+y[j];
                if(isValid(newrow, newcol, grid.length, grid[0].length) && grid[newrow][newcol] == '1')
               
                    Island(grid, newrow, newcol);
        }
        return;
    }
    private boolean isValid(int i, int j, int m, int n)
    {
        if(i<0 || i>m-1 || j<0 || j>n-1)
            return false;
        return true;
    }

    public int numIslands(char[][] grid) {
        int noOfIslands = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j]=='1')
                {
                    noOfIslands++;
                    Island(grid, i, j);
                }

            }
        }
        return noOfIslands;
    }
}