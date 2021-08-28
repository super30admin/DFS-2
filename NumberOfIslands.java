
// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach
/*Approach:
1) we have to count individual or a group of islands maybe 111
                                                           111
                                                           or 
                                                           1
2) We can either have BFS or DFS
3) In DFS approach, we just start the DFS at '1' and goes on till its surrounding is 0.
4) and once we return we increase the count.
5) Thus we move in 4 directions up, down, left, right
6) Thus we continue to move in all the dirctions and continue the dfs. As we visit the cell, we mark it to 0 or any other character.Thus we do not end up visiting it again
*/



public class NumberOfIslands {
    public int numIslands(char[][] grid) {
     
        int count=0;
        
      for(int i=0;i<grid.length;i++)
      {
          for(int j=0;j<grid[0].length;j++)
          {
              if(grid[i][j]=='1')
              {
                  dfs(grid,i,j);
                  count++;
              }
          }
      }
        
        return count;
   
    
   
        
    }
    
    public void dfs(char[][] grid, int row, int col)
    {
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]=='0')
        {
            return ;
        }
        
        grid[row][col]='0';
        dfs(grid,row-1,col);
        dfs(grid,row+1,col);
        dfs(grid,row,col-1);
        dfs(grid,row,col+1);
        
       // grid[row][col]='0';
        
    }


}
