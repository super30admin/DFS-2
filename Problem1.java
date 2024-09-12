// Time complexity: O(row*col)
// Space complexity: O(1) without recursive stack. O(m*n) with recursive stack

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int count = 0; 
        
        int row = grid.length;
        int col = grid[0].length;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, row, col, i, j);
                    count += 1;
                }
            }
        }
        
        return count;
    }
    
    int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    
    public void dfs(char[][] grid, int row, int col, int i, int j){
        grid[i][j] = '0';
        
        for(int[] direction: dirs){
            int r = i + direction[0];
            int c = j + direction[1];
            
            if( r >= 0 && r < row && c >= 0 && c < col && (grid[r][c] == '1')){
                dfs(grid, row, col, r, c);
            }
        }
    }
}
