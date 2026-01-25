import java.util.LinkedList;
import java.util.Queue;

/*
LeetCode 200. Number of Islands
*/
public class CountOfIslands {

    private int[][] dirs;
    private int m, n;

    /*
     APPROACH 1: BFS Flood Fill
     Idea:
     - When you find a '1', start BFS from that cell.
     - Push it into a queue and mark it visited by turning it into '0'.
     - While queue is not empty, expand to 4-direction neighbors.
     - Any neighbor that is '1' gets added to the queue and marked to '0'.

     Time Complexity: O(m * n)
       - each cell is visited at most once

     Space Complexity: O(m * n) worst-case
       - queue can hold many cells in one big island
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Found a new island
                if (grid[i][j] == '1') {
                    count++;

                    // start BFS flood fill

                    q.add(new int[]{i, j});

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        for (int[] d : dirs) {
                            int r = cur[0] + d[0];
                            int c = cur[1] + d[1];

                            // Correct boundary check: r < m and c < n
                            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1') {
                                q.add(new int[]{r, c});
                                grid[r][c] = '0'; // mark visited
                            }
                        }
                    }
                }
            }
        }

        return count;
    }

    /*
     APPROACH 2: DFS Flood Fill
     Idea:
     - When you find a '1', run DFS to mark the whole island as '0'.

     Time Complexity: O(m * n)
     Space Complexity: O(m * n) worst-case due to recursion stack (skewed island path)
       - average/balanced shapes often much smaller
     */
    public int numIslandsUsingDFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        // Base case: out of bounds or water
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;

        // Mark current land as visited
        grid[i][j] = '0';

        // Explore neighbors
        for (int[] d : dirs) {
            dfs(grid, i + d[0], j + d[1]);
        }
    }

    // Simple main method to test (no assertions)
    public static void main(String[] args) {
        CountOfIslands solver = new CountOfIslands();

        char[][] grid1 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        // Expected islands = 3

        // Copy grids because methods mutate (turn '1' into '0')
        char[][] grid1ForBFS = copyGrid(grid1);
        char[][] grid1ForDFS = copyGrid(grid1);

        System.out.println("Grid1 islands (BFS): " + solver.numIslands(grid1ForBFS));
        System.out.println("Grid1 islands (DFS): " + solver.numIslandsUsingDFS(grid1ForDFS));

        char[][] grid2 = {
                {'1','0','1','0'},
                {'0','1','0','1'},
                {'1','0','1','0'}
        };
        // Expected islands = 6

        char[][] grid2ForBFS = copyGrid(grid2);
        char[][] grid2ForDFS = copyGrid(grid2);

        System.out.println();
        System.out.println("Grid2 islands (BFS): " + solver.numIslands(grid2ForBFS));
        System.out.println("Grid2 islands (DFS): " + solver.numIslandsUsingDFS(grid2ForDFS));
    }

    private static char[][] copyGrid(char[][] grid) {
        char[][] copy = new char[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, copy[i], 0, grid[0].length);
        }
        return copy;
    }
}
