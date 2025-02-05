//TC: O(n)
//SC: O(n)
//approach: counting no of times bfs is done

public class NumberfIslandsDFS {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == '0')
            return;

        grid[row][column] = '0';
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int newRow = dir[0] + row;
            int newCol = dir[1] + column;
            dfs(grid, newRow, newCol);
        }
    }

}
