/**
 * time complexity O(m*n)
 * space complexity is O(m*n)
 */
class Solution {
    int[][] dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
    int m;
    int n;
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        
        this.m = grid.length;
        this.n = grid[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if(i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == '1') {
            grid[i][j] = 'x';
            for(int[] dir : dirs) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                dfs(grid, ii, jj);
            }
        }
    }
}