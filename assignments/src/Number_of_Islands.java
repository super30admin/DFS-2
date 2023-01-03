public class Number_of_Islands {

    // Approach: DFS from first island found
    // Time: O(m x n), Space: O(m x n)
    int islands = 0, rows, cols;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }
        return islands;
    }

    void dfs (char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r > rows-1 || c > cols-1 || grid[r][c] == '0')
            return;

        grid[r][c] = '0';
        dfs(grid, r+1, c);
        dfs(grid, r, c+1);
        dfs(grid, r-1, c);
        dfs(grid, r, c-1);
    }
}