/*
    Time Complexity : O(rows * columns)
    Space Complexity : O(Math.min(rows, columns))
*/
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int row=0; row<grid.length; row++){
            for(int col=0; col<grid[0].length; col++){
                if(grid[row][col]=='1'){
                    count = count + 1;
                    dfs(grid, row, col);
                }
            }
        }
        
        return count;
    }
    
    public void dfs(char[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
            return;
        }
        
        if(grid[row][col] == '0' || grid[row][col] == '2'){
            return;
        }
        
        grid[row][col] = '2';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}

