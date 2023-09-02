//BFS
// Time Complexity : O(m*n)
// Space Complexity : O(minimum(m ,n)) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int numIslands(char[][] grid) {
        int[][] dirs = new int[][]{{0,-1},{-1,0},{1,0},{0,1}};
        int m = grid.length;
        int n = grid[0].length;
        int count =0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]== '1'){   // if it is 1 change it 0 , add it to queue and process it's 4 directions using BFS
                 count++;
                 grid[i][j]='0';
                queue = new LinkedList<>();
                queue.add(new int[]{i,j});
                while(!queue.isEmpty()){
                    int[] curr = queue.poll();
                    for(int[] dir : dirs){
                        int nr = curr[0]+dir[0];
                        int nc = curr[1]+ dir[1];
                        if(nr>=0 &&nc>=0 &&nr<m && nc<n && grid[nr][nc]=='1'){   // checking 4 directions
                            grid[nr][nc] ='0';
                            queue.add(new int[]{nr,nc});
                        }
                    }
                }
            }
            }
        }
        return count;
    }
}
// DFS
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    
  public int numIslands(char[][] grid) {
         int[][] dirs = new int[][]{{0,-1},{-1,0},{1,0},{0,1}};
          int m = grid.length;
          int n = grid[0].length;
          int count =0; 
          for(int i=0;i<m;i++)
      {
          for(int j=0;j<n;j++) // for every 1 perform dfs
          {
              if(grid[i][j]== '1'){
               count++;   // increase count after when 1 comes 
               helper(grid,dirs,i,j,m,n);
              }
          }
          }
          return count;
  }

  public void helper(char[][] grid, int[][] dirs, int sr, int sc,int m , int n){
      // base case
      if(sr<0 || sc<0 || sc==n || sr ==m || grid[sr][sc]=='0') return ;    // if one condition fails return
      // logic
          grid[sr][sc] ='0'; // processed one becomes 0
          for(int[] dir : dirs)    // check 4 directions
          { 

              int nr= sr+dir[0];
              int nc= sc+dir[1];
              helper(grid,dirs,nr,nc,m,n);  // perform dfs 
          }

  }
  }