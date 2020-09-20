// Time Complexity : O(m*n) m = number of rows, n = number of columns 
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)    return 0;

        int islands = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0;j < grid[0].length; j++){
                islands += countIslands(i,j,grid);
            }
        }
        
        return islands;
    }
    
    private int countIslands(int i, int j, char[][] grid){
        if( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
            grid[i][j] == '0' || grid[i][j] == '$'){
            return 0;
        }
        
        grid[i][j] = '$';
        
        countIslands(i+1, j, grid);
        countIslands(i-1, j, grid);
        countIslands(i, j+1, grid);
        countIslands(i, j-1, grid);
        
        return 1;
    }
}
