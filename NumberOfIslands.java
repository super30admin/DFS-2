import java.util.LinkedList;
import java.util.Queue;

/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(m*n)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Using BFS or DFS traverse once an island is found and look for other islands
 */

public class NumberOfIslands {
    int m, n;
    int islands;
    int[][] dirs;
    boolean[][] visited;

    // ------------------------------------------------------ BFS Approach ------------------------------------------------------------------
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        islands = 0;
        dirs = new int[][] {
                { -1, 0 },
                { 1, 0 },
                { 0, -1 },
                { 0, 1 }
        }; // U D L R

        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islands++;
                    bfs(grid, i, j);
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { row, col });
        visited[row][col] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : dirs) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1' && !visited[nr][nc]) {
                    q.add(new int[] { nr, nc });
                    visited[nr][nc] = true;
                }
            }
        }
    }

    // ------------------------------------------------------ DFS Approach ------------------------------------------------------------------    
    public int numIslandsDfs(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        islands = 0;
        dirs = new int[][] {
                { -1, 0 },
                { 1, 0 },
                { 0, -1 },
                { 0, 1 }
        }; // U D L R

        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int row, int col) {
        // base
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != '1' || visited[row][col]) {
            return;
        }
        // logic
        visited[row][col] = true;
        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            dfs(grid, nr, nc);
        }
    }

    public static void main(String[] args) {
        // Your code here

        NumberOfIslands obj = new NumberOfIslands();
        char[][] grid = {
            {'1', '0', '1'},
            {'0', '0', '0'},
            {'1', '1', '1'},
            {'1', '0', '1'}
        };
        int count = obj.numIslands(grid);
        System.out.println(count);
        assert (count == 3);

        int count2 = obj.numIslandsDfs(grid);
        System.out.println(count);
        assert (count == count2);
    }
}