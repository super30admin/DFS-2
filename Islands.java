/*
    Time Complexity - O(m * n) where m is the number of rows and n is the number of cols
    Space Complexity - O(m * n)
 */
class Solution {
    public int numIslands(char[][] grid) {        
        int islandCount = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == '1') {
                    islandCount++;
                    dfs(grid, i , j);
                }  
        return islandCount;
    }

    public void dfs(char[][] grid, int row, int col) {

            if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
                return;
            
            if(grid[row][col] == '0')
                return;
            grid[row][col] = '0';
            dfs(grid, row - 1, col);
            dfs(grid, row + 1, col);
            dfs(grid, row, col - 1);
            dfs(grid, row, col + 1);
    }
}
