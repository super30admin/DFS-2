// Time Complexity : O(mn)
// Space Complexity : O(mn) asymptotically
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
-> For every element, if it is 1 then call DFS and increment count
-> If element is 0 or out of bounds then return
-> Else, then convert the current element to 0 and then based on the dirs array, call dfs again for all directions
*/

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0|| grid[0] == null || grid[0].length == 0){
            return 0;
        }
        
        int rows = grid.length;
        int cols= grid[0].length;
        
        int count = 0;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                    
                }
                
            }
        }
        return count;
    }
    
    private int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    
    private void dfs(char[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col<0 || col >= grid[0].length || grid[row][col]=='0'){
                return;
            }
        //convert island 1 -> 0
        grid[row][col] = '0';
        
        for(int[] dir : dirs){
            int r = row + dir[0];
            int c = col + dir[1];
            
            
            dfs(grid,r,c);
        
        
        }
    }
}