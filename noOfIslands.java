class Solution {
    int m=0;
    int n=0;
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        m=grid.length;
        n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid,int i,int j)
    {
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0')
            return;
        
        grid[i][j]='0';
        for(int[] dir:dirs)
        {
            int r=i+dir[0];
            int c=j+dir[1];
            dfs(grid,r,c);
        }
            
    }
}

// Time Compelxity: O(m*n)
// Space Complexity: O(m*n)