// Time Complexity O(m * n)
// Space Complexity O(m * n)

public class NumberOfIslandsDFS {

    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        // DFS function
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If a land cell ('1') is found, perform DFS
                if (grid[i][j] == '1') {
                    islandCount++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }

        return islandCount;
    }

    // DFS to mark all connected land cells as visited
    private static void dfs(char[][] grid, int row, int col, int rows, int cols) {
        // If out of bounds or water, return
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }

        // Mark current cell as visited
        grid[row][col] = '0';

        // Explore all 4 directions
        for (int[] dir : directions) {
            dfs(grid, row + dir[0], col + dir[1], rows, cols);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println("Number of Islands (DFS): " + numIslands(grid));
    }
}

