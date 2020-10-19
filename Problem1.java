// Time Complexity : O(MN)
// Space Complexity : O(1) as we are not using extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Using DFS

class Solution {
    public int numIslands(char[][] grid) {
        //Base case
        if(grid == null) return 0;
        
        int output = 0;
        int nrow = grid.length;
        int ncol = grid[0].length;
        
        for(int i = 0; i < nrow; i++){
            for(int j = 0; j < ncol; j++){
                if(grid[i][j] == '1'){
                    output++;
                    helper(i, j, grid);
                }
            }
        }
        return output;
    }
    
    private void helper(int i, int j, char[][] grid){
        grid[i][j] = '0';
        int nrow = grid.length;
        int ncol = grid[0].length;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] drs: dirs){
            int new_row = i + drs[0];
            int new_col = j + drs[1];
            if(new_row >= 0 && new_row < nrow && new_col >= 0 && new_col < ncol && grid[new_row][new_col] == '1'){
                helper(new_row, new_col, grid);
            }
        }
    }
}
