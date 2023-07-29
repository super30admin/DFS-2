package DFS2;

// Time Complexity : O(m*n)  -> 2mn
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

public class NumbeerOfIslandsUsingDFS {

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int m,n;
    public int numIslands(char[][] grid) {

        this.m = grid.length;
        this.n = grid[0].length;
        int count = 0;

        for(int i=0; i<m; i++)
        {
            for( int j=0; j<n; j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,int i,int j)
    {
        if(i<0 || i==m || j<0 || j==n || grid[i][j]=='0') return;
        grid[i][j] = '0';
        for(int[] dir:dirs)
        {
            int r = dir[0]+i;
            int c = dir[1]+j;
            dfs(grid,r,c);

        }
    }
}
