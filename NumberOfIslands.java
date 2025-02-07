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

    public static void main(String[] args) {
        // Your code here

    }
}