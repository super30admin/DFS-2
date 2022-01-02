// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// DFS solution
// Traverse the grid and if you encounter a 1, run a dfs and mark its neighbors as 0 if they are 1
// Maintain a count variable that will keep track of the count of the islands, increment it when you encounter a 1
class Solution {
    int m, n;
    int[][] dirs;

    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ++count;
                }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        for (int[] dir: dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            dfs(grid, nr, nc);
        }
    }
}