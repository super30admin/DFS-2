// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//1. using DFS and BFS 
//2. go through the entire matrix till you find island call Dfs on that index and increase islandFoundCount by 1
//3. in DFS call, using BFS make all connected islands = 0 /water 

class Solution {
    int count=0;
    int m = 0;
    int n = 0;
     Queue<int[]> q = new LinkedList<>();
      int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        m = grid.length;
       n = grid[0].length;
        count =0;
        
         for(int i = 0; i < m ; i++)
        {
            for(int j = 0; j< n; j ++)
            {
                if(grid[i][j] == '1')
                {
                    grid[i][j] = '0';
                    count++;
                    helper(grid,new int[]{i,j}); 
                }
            }
        }  
      
        return count;
    }
    
    private void helper(char[][] grid , int[] index)
    {
        int r = index[0]; int c = index[1];
        if(index[0] > m || index[0] < 0 || index[1] > n || index[1] < 0 )
            return ;
     
            q.add(new int[]{r,c});
            while(!q.isEmpty())
            {
                int[] curr = q.poll();
              for(int[] dir : dirs)
                {
                    int r1 = curr[0] + dir[0];
                     int c1 = curr[1] + dir[1];

                   if(r1 >= 0 && r1 < m && c1 >= 0 && c1 < n && grid[r1][c1] == '1')
                  {
                     grid[r1][c1] = '0';
                     q.add(new int[]{r1,c1});
                  }

                }
            }
       
    }
}