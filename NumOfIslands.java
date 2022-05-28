// Time Complexity : O(M*N)= O(MN) + O(MN), one for dfs and other for looping through the matrix
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class NumOfIslands {
    private int[][] dirs;
    int m;
    int n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};

        int numIslands = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i>=m || j<0 || j>=n) return;
        if(grid[i][j] == '0') return;
        grid[i][j] = '0';
        for(int[] dir: dirs) {
            dfs(grid, i+ dir[0],j+dir[1]);
        }
    }
}
