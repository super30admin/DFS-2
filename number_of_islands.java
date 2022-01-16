// Time Complexity : O(m*n) - 2D grid
// Space Complexity : O(m*n) - 2D grid

class Solution {
    public int numIslands(char[][] grid) {
     
        
        // if empty grid
        if (grid.length == 0 || grid == null){
            return 0;
        }
        // rows 
        int m =  grid.length;
        
        // columns
        int n = grid[0].length;
       
        int count = 0;
        
        for (int i=0; i < m ; i++){
            
            for (int j=0; j< n; j++){
                
                if (grid[i][j] == '1'){
                    count += dfs(grid, i, j);
                }
                
            }
        }
        
        return count;
    }
    
    
    private int dfs(char[][] grid, int i, int j){
        
        
        if ( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            
            // if out of bound or value is 0 : not an island
            return 0;
        }
        
        //mark visited
        grid[i][j] = '0';
        
    
        // check for the neighbours horizontally or vertically to consider it as one island
       dfs(grid, i, j+1);
       dfs(grid, i, j-1);
       dfs(grid, i+1, j);
       dfs(grid, i-1, j);
        
    
        return 1;

    }
    
}