
// Time Complexity: O(m * n)
// Space Complexity: O(m * n)

import java.util.*;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        // directions for right, down, up, left
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Start BFS when land '1' is found
                if (grid[i][j] == '1') {
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    grid[i][j] = '0';

                    // BFS traversal
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        for (int[] dir : dirs) {
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];

                            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1') {
                                q.add(new int[]{r, c});
                                grid[r][c] = '0';
                            }
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOfIslands sol = new NumberOfIslands();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int result = sol.numIslands(grid);
        System.out.println("Number of islands: " + result); // Expected output: 3
    }
}
