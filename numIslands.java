// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Iterate through the grid and if the cell is not visited and is 1 then increment the count and call dfs on the cell.
 * 2. In dfs, mark the cell as visited and call dfs on all the 4 directions.
 * 3. If the cell is out of bounds or is visited or is 0 then return.
 * 4. In the main function return the count.
 */

class Solution {
    int[][] dirs;
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        this.dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    countIslands(grid, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private void countIslands(char[][] grid, int row, int col, boolean[][] visited){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || 
                visited[row][col] || grid[row][col] == '0'){
            return;
        }

        visited[row][col] = true;
        for(int[] dir : dirs){
            int nrow = row + dir[0];
            int ncol = col + dir[1];
            countIslands(grid, nrow, ncol, visited);
        }
    }
}