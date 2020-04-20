
//TC:O(n*m)
//SC:o(1)

class Solution {
    
    int x[]={0,0,-1,1};
    int y[]={-1,1,0,0};
    public int numIslands(char[][] grid) 
    {
      if(grid==null||grid.length==0) return 0;
      int row = grid.length;
      int col = grid[0].length;
      int count=0;
      for(int i=0;i<row;i++)
      {
        for(int j=0;j<col;j++)
        {
          if(grid[i][j]=='1')
          {
             count++;
             grid[i][j]='0';
             dfs(i,j,grid); 
          }
        } 
      }
        
        return count;
    }
    
    
   public void dfs(int sr,int sc,char[][] grid)
   {
      for(int i=0;i<x.length;i++)
        {
          int row = sr+x[i];
          int col = sc+y[i];
          if(row>=0&&col>=0&&row<grid.length&&col<grid[0].length&&(grid[row][col]=='1'))
          { 
               grid[row][col]='0';
               dfs(row,col,grid);
          }
        }
       
       
   }
    
    
    
    
    
    
}