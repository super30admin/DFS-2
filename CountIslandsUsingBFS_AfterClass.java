// Time Complexity : O(mn)
// Space Complexity : min of no of rows or columns in grid
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//1. using BFS 
//2. go through the entire matrix till you find island , add it into q, check all four sides of this elemment and make 0 

//3.   move and next 1 in q 

class Solution {
    int m =0;
    int n = 0;
    int count =0;
    
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if(m ==0 || grid == null) return -1;
        count =0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;  i< m ; i++)
        {
             for(int j = 0;  j< n ; j++)
            {
                 if(grid[i][j] == '1')
                 { 
                     q.add(new int[]{i,j});
                     count++;
                    while(!q.isEmpty())
                    {
                       grid[i][j] = '0';
                          int[] curr = q.poll();
                        for( int[] dir : dirs)
                        {
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                             if(r < m && r >= 0 && c < n && c >= 0 && grid[r][c] =='1') 
                           {
                                grid[r][c] = '0'; 
                                q.add(new int[]{r,c});
                            }
                        } 
                    }
                 }
            }
        }
        
        return count;
    }
    
 
}