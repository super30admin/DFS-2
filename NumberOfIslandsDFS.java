import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsDFS {

    // DFS approach
    // TC: O(m * n) m - number rows  n - number of columns
    // SC: O(m * n)
    int[][] dirs;
    int rows, columns;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int total = 0;

        dirs = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        rows = grid.length;
        columns = grid[0].length;

        // This nested for loop is to search for occurrence of 1
        // As soon as we find 1, initiate the BFS process
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    total++;

                    dfs(grid, i, j);
                }
            }
        }
        return total;
    }

    private void dfs(char[][] grid, int r, int c) {
        // base case condition
        if(r < 0 || r == rows || c < 0 || c == columns || grid[r][c] != '1') return;

        grid[r][c] = '0';

        // logic
        for(int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(grid, nr, nc);
        }
    }
}
