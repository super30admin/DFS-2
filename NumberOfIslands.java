// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//In this approach we are using a bfs.Whenever we see a '1' , we start a bfs with that as the root node and make all the 1's as zeroes.
//We increment the count every time we do the above step and return the count in the end.
class Solution {
    public int numIslands(char[][] grid) {
      
      if(grid==null || grid.length==0)
      {
        return 0;
      }
      int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
      int m = grid.length;
      int n = grid[0].length;
      int count =0;
      Queue<Integer> queue = new LinkedList<>();
      for(int i=0;i<m;i++)
      {
        for(int j=0;j<n;j++)
        {
          if(grid[i][j]=='1')
          {
            count++;
            queue.add(i);
            queue.add(j);
            grid[i][j]='0';
            while(!queue.isEmpty())
            {
              int k = queue.poll();
              int l = queue.poll();

              for(int[] dir : dirs)
              {
                int r = dir[0]+k;
                int c = dir[1]+l;


                if(r>=0 && r<m && c>=0 && c<n && grid[r][c]=='1')
                {
                  queue.add(r);
                  queue.add(c);
                  grid[r][c]='0';
                }

              }
            }
          }
        }
      }
      
      
      return count;
    }
}





// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//In this approach we are using a dfs.Whenever we see a '1' , we start a dfs and keep on making the ones as 0s untill we see a 0.
//We increment the count every time we do the above step and return the count in the end.



class Solution {
  int m ,n;
    public int numIslands(char[][] grid) {
      
      if(grid==null || grid.length==0)
      {
        return 0;
      }
      
       m = grid.length;
       n = grid[0].length;
      int count =0;
      
      Queue<Integer> queue = new LinkedList<>();
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
  
  private void dfs(char[][] grid,int i , int j)
  {
    if(i<0 || j<0 || i==m || j==n || grid[i][j]=='0' )
      return;
    
    grid[i][j]='0';
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    for(int[] dir:dirs)
    {
      int r = dir[0] + i;
      int c = dir[1] + j;
      dfs(grid,r,c);
    }

  }
}