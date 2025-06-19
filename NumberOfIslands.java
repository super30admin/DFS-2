import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode 200. Number of Islands
 * Link: https://leetcode.com/problems/number-of-islands/description/
 */
//------------------------------------ Solution 1 -----------------------------------
public class NumberOfIslands {
    /**
     * BFS solution
     *
     * TC: O(mn) SC: O(mn)
     */
    public int numIslands(char[][] grid) {
        int result = 0;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    bfs(grid, dirs, i, j);
                }
            }
        }
        return result;
    }

    private void bfs(char[][] grid, int[][] dirs, int r, int c) {
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(r);
        bfsQueue.add(c);
        grid[r][c] = '2';

        while(!bfsQueue.isEmpty()) {
            int row = bfsQueue.poll();
            int col = bfsQueue.poll();

            for (int[] dir: dirs) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[nr].length && grid[nr][nc] == '1') {
                    bfsQueue.add(nr);
                    bfsQueue.add(nc);
                    grid[nr][nc] = 2;
                }
            }
        }
    }
}

//------------------------------------ Solution 2 -----------------------------------
class NumberOfIslands2 {
    /**
     * DFS Solution
     *
     * TC: O(mn) Auxiliary SC: O(1)
     * Recursive stack SC: O(mn)
     */
    public int numIslands(char[][] grid) {
        int result = 0;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, dirs, i, j);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int[][] dirs, int r, int c) {
        //base
        if (grid[r][c] == '2') {
            return;
        }

        //logic
        grid[r][c] = '2';

        for (int[] dir: dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[nr].length && grid[nr][nc] == '1') {
                dfs(grid, dirs, nr, nc);
            }
        }
    }
}
