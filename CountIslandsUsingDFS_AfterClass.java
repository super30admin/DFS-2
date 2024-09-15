// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//1. using DFS 
//2. go through the entire matrix till you find island call Dfs on that index and increase islandFoundCount by 1
//3. in DFS call,  make all connected islands = 0 /water 

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
        for(int i = 0;  i< m ; i++)
        {
             for(int j = 0;  j< n ; j++)
            {
                 if(grid[i][j] == '1')
                 { 
                     count++;
                     dfs(grid, i, j);
                 }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int i , int j)
    {
        if(i == m || i < 0 || j == n || j <0 || grid[i][j] =='0') return;
        
        grid[i][j] = '0';
        
        for( int[] dir : dirs)
        {
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, r,c);
        }
    }
}