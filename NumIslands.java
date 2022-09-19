/* 
## Problem1: (https://leetcode.com/problems/number-of-islands/)
 
Time Complexity :   O (M*N) 
Space Complexity :  O (M*N) 
Did this code successfully run on Leetcode :    Yes (200. Number of Islands)
Any problem you faced while coding this :       No
 */

// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1

class NumIslands {
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        dirs = new int[][]{{0,1}, {-1, 0}, {0, -1}, {1, 0}};
        
        int count = 0;
        
        for(int i=0; i<m; i++){
            for(int j = 0; j<n ; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j, int m, int n){
         // base case
        if(i < 0 || j < 0 || i==m || j==n || grid[i][j] == '0')
            return;
        
        // logic
        grid[i][j] = '0';
        for(int dir[]: dirs){
            int nr = dir[0] + i;
            int nc = dir[1] + j;

            dfs(grid, nr, nc, m, n);
        }
    }
}