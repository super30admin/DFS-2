// Time Complexity : O(Rows x Columns) 
// Space Complexity : O(Rows x Columns)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        for(int i = 0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1'){
                    ++res;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    
    public void dfs(char[][] grid, int r, int c){
        int row = grid.length;
        int col = grid[0].length;
        
        if(r < 0 || c < 0 || r >= row || c>=col || grid[r][c] == '0'){
            return;
        }
        
        grid[r][c] = '0';
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }
}