// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    private void dfs(char[][] grid , int row , int col){
        
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length ||  grid[row][col] != '1'){
              return; 
        }
         grid[row][col] = '#';
        
         dfs(grid , row+1 , col);
         dfs(grid , row , col+1);
         dfs(grid , row-1 , col);
         dfs(grid , row , col-1);
    }
    public int numIslands(char[][] grid) {
       
        int count = 0;
        
        for(int i = 0 ; i < grid.length ; i++){
            
            for(int j = 0 ; j < grid[0].length ; j++){
                
                if(grid[i][j] == '1'){
                   
                    count++;
                    
                    dfs(grid , i , j);
                }
            }
            
        }
        
        return count;
    }
}