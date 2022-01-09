//https://leetcode.com/submissions/detail/616342159/
//Space: O(1)
//Time: m*n

class Solution {
    
    private static int[][] dirs = {
        {1, 0}, //Down
        {-1, 0}, //Up
        {0, -1}, //Left
        {0, 1} //Right
    };
    
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int numberOfIslands = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    numberOfIslands++;
                    dfs(i, j, grid, m, n);
                }
            }
        }
        return numberOfIslands;
    }
    
    private void dfs(int row, int col, char[][] grid, int rows, int cols) {
        //base
        if(row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] != '1') {
            return;
        }
        
        grid[row][col] = '2';
        
        for(int[] dir: dirs){
            dfs(row+dir[0], col+dir[1], grid, rows, cols);
        }
    }
    
}