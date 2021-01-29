// Time Complexity : O(m*n) 
// Space Complexity : O(m*n) ? Not sure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    int m;
    int n;
     
    public int numIslands(char[][] grid) {
        
        m = grid.length;
        n = grid[0].length;
        int numOfIslands = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(grid,i,j);
                    numOfIslands++;
                }
            }
        }
      
        return numOfIslands;
    }
    
    private void dfs(char[][] grid,int r,int c)
    {
        grid[r][c]='2';
        int [][]dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int []dir : dirs )
        {
           int row = r+dir[0];
           int col = c+dir[1];
           if(row>=0 && row<m && col>=0 && col<n && grid[row][col]=='1')
           {
               dfs(grid,row,col);
           }  
        }
    }
}