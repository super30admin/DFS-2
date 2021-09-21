// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    boolean[][] visited;
    int m;
    int n;
    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        visited = new boolean[m][n];
        int islandCount = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    islandCount++;
                    dfs(grid, i, j);
                }
            }
        }
        return islandCount;
    }
    public void dfs(char[][] grid, int row, int col) {
        if(row >= 0 && row < m && col >= 0 && col < n && !visited[row][col] && grid[row][col] == '1') {
            visited[row][col] = true;
            dfs(grid, row + 1, col);
            dfs(grid, row - 1, col);
            dfs(grid, row, col + 1);
            dfs(grid, row, col - 1);
        }
    }
}