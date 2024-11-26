// Time complexity:  O(m* n)
// Space complexity: O(m* n)
import java.util.*;

public class NumberofIslandsBFS {

    // Directions for exploring (up, down, left, right)
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        // BFS function
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If a land cell ('1') is found, perform BFS
                if (grid[i][j] == '1') {
                    islandCount++;
                    bfs(grid, i, j, rows, cols);
                }
            }
        }

        return islandCount;
    }

    // BFS to mark all connected land cells as visited
    private static void bfs(char[][] grid, int row, int col, int rows, int cols) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = '0';  // Mark as visited

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] dir : directions) {
                int newRow = current[0] + dir[0];
                int newCol = current[1] + dir[1];

                // Check if within bounds and if it's land ('1')
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1') {
                    grid[newRow][newCol] = '0';  // Mark as visited
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println("Number of Islands (BFS): " + numIslands(grid));
    }
}
