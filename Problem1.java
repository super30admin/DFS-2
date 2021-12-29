// 200 Number of islands
// Time O(m * n)
// Space Space Complexity : O(Minimum(m,n))
class Solution {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                
                if(grid[i][j] == '1'){
                    
                    numOfIslands++;
                    helper(grid, i, j);
                }
            }
        }
        
        return numOfIslands;
    }
    
    public void helper(char[][] grid, int row, int col){
        
        if(grid[row][col] == '#'){
            return;
        }
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        grid[row][col] = '#';
            
        for(int [] direction: directions){
            
            int nRow = row + direction[0];
            int nCol = col + direction[1];
            
            if(nRow>= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length &&grid[nRow][nCol] == '1'){
                
                helper(grid, nRow, nCol);
            }
        }
        
    }
}