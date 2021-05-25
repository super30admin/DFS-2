// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(mn) as we are iterating through the entire matrix
//Space Complexity: O(1) since we are not taking any extra space 
class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for(int i=0 ; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == '1'){
                    count++;
                    helper(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public void helper(char[][] grid, int i, int j){
        
        //Base Case
                                                                        
        if( i < 0 || i > grid.length-1 || j < 0 || j > grid[0].length-1 || grid[i][j] == '0'){
            return;
        }
        
        // Change 1s to 0
        grid[i][j] = '0';
        
        //Up
        helper(grid, i-1, j);
            
        //Down
        helper(grid, i+1, j);
        
        //Right
        helper(grid, i, j+1);
        
        //Left
        helper(grid, i, j-1);

    }
}