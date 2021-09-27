// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int m;
    int n;
    // initialize dirs array
    int[][] dirs = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        // get the number of rows and columns
        m = grid.length;
        n = grid[0].length;
        // intialize count as 0
        int count = 0;
        // iterate through the matrix
        // if '1' is found, increse the count
        // and perform dfs on that index
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int row, int col){
        // base
        // check for bounds
        // return if the element is not equal to 1
        if(row < 0 || row >= m || col >= n || col < 0 || grid[row][col] != '1') return;
        // logic
        // mark the visited elements as '0'
        grid[row][col] = '0';
        // iterate through the dirs array and call dfs function recursively
        for(int[] dir: dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfs(grid, newRow, newCol);
        }
    }
}