class Solution {

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int m, n;

    public int numIslands(char[][] grid) {

        m = grid.length;
        n = grid[0].length;

        int islands = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++; // one full island finished
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int i, int j) {

        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0'; // mark visited

        for(int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}