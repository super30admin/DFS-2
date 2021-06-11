// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We use DFS to explore all cells where the value is 1. Once visited we set the value to '$'.
*/

class Solution {
    
    int count;
    public int numIslands(char[][] grid) {
    
        count = 0;
        
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                
                if (grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        
        
        return count;
    }
    
    public void dfs(char[][] grid, int r, int c){
        
        if (r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c] == '$' || grid[r][c] == '0') return;
        
        grid[r][c] = '$';

        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        for (int[] dir : dirs)
            dfs(grid, r+dir[0], c+dir[1]);
    }
}