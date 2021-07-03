// Time Complexity :O(m*n) m-row length n-column length
// Space Complexity :O(m*n)  // Stack Space
// Did this code successfully run on Leetcode :yes

class Solution {
    
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int m=grid.length; int n=grid[0].length;
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
        //base case
        if(i==grid.length || i<0 || j==grid[0].length || j<0 || grid[i][j]=='0') return;
        
        //logic
        grid[i][j]='0'; // make it marked
        
        //call neighbours and mark 1s nearby to consider all 1's together as an one island
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}