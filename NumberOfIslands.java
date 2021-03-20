class NumberOfIslands {
    
    // Time Complexity: O(nm)   (where n -> no. of rows and m -> no. of cols)
    // Space Complexity: O(nm)
    
    public int numIslands(char[][] grid) {
        // Edge Case Checking
        if(grid == null || grid.length == 0)
            return 0;
        int numOfIslands = 0;
        
        // Traverse throught the grid to find the islands and do a DFS
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    numOfIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numOfIslands;
    }
    
    private void dfs(char[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0')
            return;
        // Convert the island (1) to 0
        grid[row][col] = '0';
        
        // Traverse in all four directions to find connected island components
        dfs(grid, row+1, col);
        dfs(grid, row-1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);
        
        return;
    }
}