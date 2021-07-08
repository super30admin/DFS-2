class NumberOfIslands {

    //Time and Space: O(m x n)
    public int numIslands(char[][] grid) {

        int islands = 0;

        for (int i=0; i<grid.length; i++) {

            for (int j=0; j<grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;

    }

    public void dfs(char[][] grid, int row, int col) {

        //Check conditions
        if (row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1) {
            return;
        }

        if (grid[row][col] == '0') {
            return;
        }

        //Process cell

        grid[row][col] = '0';

        //Visit all neighbours
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);

    }