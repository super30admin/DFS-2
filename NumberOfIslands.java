// Time Complexity : O(m*n) where m and n are dimention of the matrix
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Run a loop for each cell in the matrix, if any of the matrix is land or 1 call dfs from it.
//We will change land to water or 0 during dfs
//The no of times we call the dfs is the number of islands we will have in the matrix

class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }
    private void dfs(char[][] grid, int i, int j){
        //base
        //explore
        grid[i][j] = '0';
            for(int [] dir: directions){
                int newi = i + dir[0];
                int newj = j + dir[1];
                if(newi >= 0 && newi < grid.length && newj >= 0 && newj < grid[0].length && grid[newi][newj] == '1')
                    dfs(grid, newi, newj);
            }
    }
}