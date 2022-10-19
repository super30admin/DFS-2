// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class Islands {
    int [][]dirs;
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
        {
            return 0;
        }
        
        dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for(int i = 0; i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    dfs(grid,i,j,m,n);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j,int m,int n)
    {
        //base
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0')
        {
            return;
        }
        //logic
        grid[i][j] = '0';
        for(int[] dir:dirs)
        {
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            
            dfs(grid,nr,nc,m,n);
        }
    }
}
