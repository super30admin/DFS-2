// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int[][] dirs;
    int count;
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        dirs = new int[][] {{0,1},{-1,0},{0,-1},{1,0}};
        count = 0;
        
        // traverse through the grid matrix
        for(int i = 0; i < m; i++){
            for(int j= 0 ; j < n; j++){
                // if 1 is found, run dfs on element and increae the count of island
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
        
    }
    
    private void dfs(char[][] grid, int i, int j, int m, int n){
        //base
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0') return;
            
        //logic
        // make the current element as 0 since it is already counted
        grid[i][j] = '0';
        
        // prcoessing the neighbors 
        for(int [] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            
            // calling dfs on neighbors
            dfs(grid, r, c, m, n);
        }
        
    }
}