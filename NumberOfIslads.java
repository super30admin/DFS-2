// Time complexity:- O(m * n)
// Space complexity:- O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/**
 * Approach:
 * 
 * 
 */
// DFS Solution
class Solution {
    char[][] grid;
    int rows;
    int cols;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        
        // iterate over the grid to do recursive calls and count islands
        int count = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j) {

        // base condition
        if(i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '2' || grid[i][j] == '0') {
            return;
        }

        // process 
        if(grid[i][j] == '1') {
            grid[i][j] = '2';
        }

        // recurse up
        dfs(i - 1, j);

        // recurse right
        dfs(i, j + 1);

        // recurse down
        dfs(i + 1, j);

        // recurse left
        dfs(i , j - 1);

    }
}