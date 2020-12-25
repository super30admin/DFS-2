// Time Complexity : O(M*N)
// Space Complexity :  O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
class Solution {
    int rows;
    int cols;
    // boolean[][] visited;
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        rows = grid.length;
        cols = grid[0].length;
        // visited = new boolean[rows][cols];
        int count = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1' ) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    public void dfs(char[][] grid, int row, int col) {
        
        if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] != '1')
            return;
        
        grid[row][col] = '2';
        
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);

        
    }
}