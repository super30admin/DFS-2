// Time Complexity : O(m * n)
// Space Complexity : O[2(min(m,n))] --> O(min(m,n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    class Pair {
        int row;
        int column;
        
        Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
    
    private static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    
    private void bfs(int row, int col, char[][] grid,int rows, int columns) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        
        grid[row][col] = '2';
        
        while(!q.isEmpty()) {
            Pair pair = q.poll();
            
            for(int[] dir : dirs) {
                int newRow = pair.row + dir[0];
                int newCol = pair.column + dir[1];
                
                if (newRow < rows && newRow >= 0 && newCol < columns && newCol >= 0 && grid[newRow][newCol] == '1') {
                    grid[newRow][newCol] = '2';
                    q.add(new Pair(newRow, newCol));
                } 
            }
        }
    }
                     
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        
        int noOfIslands = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j =0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    ++noOfIslands;
                    bfs(i, j, grid, rows, columns);
                }
            }
        }
        
        return noOfIslands;       
    }
}
                     
  