class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null)
            return 0;
        int islands = 0;
        int r = grid.length;
        int c = grid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    ++islands;
                    change(grid, i, j);
                }
            }
        }
        return islands;
    }

    private void change(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        change(grid, i, j - 1);
        change(grid, i, j + 1);
        change(grid, i - 1, j);
        change(grid, i + 1, j);
    }
}