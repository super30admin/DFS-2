// Time Complexity : O(m * n) --> where m and n are lengths of input 2D matrix
// Space Complexity : O (m * n)
// Did this code successfully run on Leetcode (200): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int dirs[][];
    int m;
    int n;
    public int numIslands(char[][] grid) {
        // edge case
        if (grid == null || grid.length == 0) return 0;
        
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        // base case
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
        
        // logic
        grid[i][j] = '0';        
        for (int dir[] : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, r, c);
        }
    }
}