//Time Complexity: O(m x n) 
//Space Complexity: DFS: O(m x n)
//                  BFS: O(min(m,n))
class Solution {
    public int numIslands(char[][] grid) {
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        int m = grid.length;
        int n = grid[0].length;
        int numOfIslands = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == '1') {
                    numOfIslands++;
                    dfs(grid, i, j, dirs);
                }

        return numOfIslands;
    }

    private void dfs(char[][] grid, int r, int c, int[][] dirs) {
        // base
        if (r < 0 || c < 0 || r > grid.length - 1 || c > grid[0].length - 1 || grid[r][c] == '0')
            return;

        // logic
        grid[r][c] = '0';
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(grid, nr, nc, dirs);
        }
    }
}