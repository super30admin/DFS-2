// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
// 	not a intuitive solution

// Your code here along with comments explaining your approach

class Solution {
   private void markVisited(char[][] grid, Boolean[][] visited, int startRow, int startCol, int row, int col) {
        if(startRow == row || startCol == col || startRow < 0 || startCol < 0) {
            return;
        }
        if(grid[startRow][startCol] == '0' || visited[startRow][startCol] == true) {
            return;
        }
        visited[startRow][startCol] = true;
        markVisited(grid, visited, startRow + 1, startCol, row, col);
        markVisited(grid, visited, startRow, startCol + 1, row, col);
        markVisited(grid, visited, startRow - 1, startCol, row, col);
        markVisited(grid, visited, startRow, startCol - 1, row, col);
    }
    
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if(row == 0)
            return 0;
        int col = grid[0].length;
        int count = 0;
        Boolean visited[][] = new Boolean[row][col];
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                visited[i][j] = false;
            }
        }
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(visited[i][j] == false && grid[i][j] == '1') {
                    count++;
                    markVisited(grid, visited, i, j, row, col);
                }
            }
        }
        return count;
    }
}