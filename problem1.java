import java.util.LinkedList;
import java.util.Queue;

public class problem1 {

    // Time and Space Complexity: 0(m*n)

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') { // Found an unvisited land cell
                    numIslands++;
                    dfs(grid, row, col); // Mark all connected land cells as visited
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Check bounds and stop if cell is water ('0') or already visited ('2')
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0'; // Mark the cell as visited by converting '1' to '0'

        // Explore the four directions
        dfs(grid, row + 1, col); // Down
        dfs(grid, row - 1, col); // Up
        dfs(grid, row, col + 1); // Right
        dfs(grid, row, col - 1); // Left
    }
    // bfs
    public int numIslandsbfs(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows= grid.length;
        int cols = grid[0].length;
        int numOfIslands = 0;
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == '1') {
                    bfs(grid, row, col);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }
    void bfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = '0';

        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int rowIdx = cur[0];
            int colIdx = cur[1];

            for (int[] dir: dirs) {
                int newRow=rowIdx+dir[0];
                int newCol=colIdx+dir[1];
                if (newRow>=0 && newRow<rows && newCol>=0 && newCol<cols && grid[row][col] == '1') {
                    grid[row][col] = '0';
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }




    }

}
