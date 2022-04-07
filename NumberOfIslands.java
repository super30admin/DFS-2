// Time Complexity : O(2*m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {

    //DFS approach

    int m; int n;
    int[][] directions;

    public int numIslands(char[][] grid) {

        directions = new int[][] {
            {-1,0},{1,0},{0,-1},{0,1}
        };

        m = grid.length;
        n = grid[0].length;

        int count = 0;

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == '1')
                {
                    //increase count and run dfs
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j)
    {
        //base

        //check bounds
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] == '0')
            return;

        //logic

        //make it '0'
        grid[i][j] = '0';

        //iterate over neighbors to find 1
        for(int[] d : directions)
        {
            int r = d[0] + i;
            int c = d[1] + j;

            dfs(grid, r, c);
        }
    }
}
