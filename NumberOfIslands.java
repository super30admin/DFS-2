import java.util.*;
import java.util.LinkedList;

//bfs
// Time Complexity : O(m * n) where m is the number of rows and n is the number of columns in the grid
// Space Complexity : O(min(m, n)) for the auxiliary ds queue used in BFS traversal
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Intuition: used BFS to traverse the grid and mark all the cells of the island as visited
class NumberOfIslandsBFS {
    int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<int[]> queue = new LinkedList();

        // add starter locations for bfs
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    queue.offer(new int[] { i, j });
                    grid[i][j] = '0';

                    while (!queue.isEmpty()) {
                        // no need of size here as we are storing the entire connected component as 1
                        // unit and no need of levels here
                        int[] curr = queue.poll();
                        for (int[] dir : dirs) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];

                            if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') { // positive conditions
                                                                                                 // with OR
                                // add neighbor cells to queue
                                queue.offer(new int[] { nr, nc });
                                grid[nr][nc] = '0'; // do not visit them
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}

// dfs
// Time Complexity : O(m * n) where m is the number of rows and n is the number
// of columns in the grid
// Space Complexity : O(m * n) for the recursion stack in the worst case, which
// can be O(m * n) if all cells are land
// points for each number
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class NumberOfIslandsDFS {
    int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<int[]> queue = new LinkedList();
        // add starter locations for bfs
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, m, n, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int m, int n, int i, int j) {
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j] != '1')
            return; // negative conditions with OR
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            dfs(grid, m, n, nr, nc);
        }
    }
}