// Time Complexity : O(m*n) m*n is matrix dimensions
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class numIslands {
    
    public void dfs(char[][] grid,int r,int c)
    {
        int nr = grid.length;
        int nc = grid[0].length;
        
        if(r>=nr || c>=nc || r<0 || c<0 || grid[r][c] == '0') return;
        
        grid[r][c] = '0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }
    
    public int numIslands(char[][] grid) {
        
        if(grid.length==0 || grid == null) return 0;
        
        int nr = grid.length;
        int nc = grid[0].length;
        
        int numIslands = 0;
        
        for(int i=0;i<nr;i++)
            for(int j=0;j<nc;j++)
            {
                if(grid[i][j]=='1')
                {numIslands++; dfs(grid,i,j);}
            }
        
        return numIslands;
        
    }
}