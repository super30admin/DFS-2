// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        
        int count =0;
        
     
       
        if(grid.length == 0 || grid == null || grid[0].length==0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(grid,i,j,m,n);
                    ++count;
                }   
            }
        }
       return count; 
    }
    
    private void dfs(char[][] grid,int i , int j, int m , int n)
    {
        
        if(i<0||i>=m||j<0||j>=n || grid[i][j]!='1') return ;
        grid[i][j] = '0';
        for(int[] dir : dirs)
        {
            dfs(grid, i + dir[0] , j + dir[1] ,m,n);
        }   
        
        
        
        
        
    }    
}