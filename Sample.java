//****NUMBER OF ISLAND-  DFS APPROACH****
// Time Complexity : O(m*n);
// Space Complexity :o(m*n)
// Did this code successfully run on Leetcode :Y
// Any problem you faced while coding this :N

class Solution {
    int [][] dirs;
    int m;
    int n; 
    public int numIslands(char[][] grid) 
    {
        //Boiler plate code for going in 4 different directions
        m=grid.length;
        n=grid[0].length;  
        
        //Directions array      //u     //D  //L    //R
        dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        
        int count=0;
        //Iterate through given matrix
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    dfs(grid,i,j,m,n);
                }
            }
        }
     return count;   
    }
    
    private void dfs(char[][] grid, int i, int j, int m, int n)
    {
        //Base
        if(i==m || j==n || i<0 || j<0 || grid[i][j]=='0')
        {
            return;
        }
        
        //Logic
        grid[i][j]='0';
        //Check if there is 1 in its other 4 directions
        for(int[] dir: dirs)
        {
            int nr=dir[0]+i;
            int nc=dir[1]+j;
            
            dfs(grid,nr,nc,m,n);
        }
    }
}

// Your code here along with comments explaining your approach
