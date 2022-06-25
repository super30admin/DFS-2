//Time and space O(m*n)

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    dfs(i,j,grid,m,n);
                   
                }
            }
        }
        
        return count;
    }
    
    private void dfs(int i , int j , char[][]grid, int m , int n)
    {
        //base case
        if(i>=m || i<0 || j>=n || j<0 || grid[i][j]=='0')
            return;
        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        grid[i][j]='0';
     
        
        for(int d[]:dirs)
        {   int nr, nc;
            nr =  i +d[0];
            nc = j+ d[1];
            dfs(nr,nc,grid, m, n);
         
        }
       
    }
}