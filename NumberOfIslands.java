import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    // dfs
    // time o(mXn)
    // space 0(mXn)
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// U D L R
        int count = 0;
        /// iterate through the grid to find '1.' if found put in q and start bfs.

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    Queue<int[]> q = new LinkedList<>();
                    count++;
                    q.add(new int[] { i, j });
                    // mark visited
                    grid[i][j] = '2';
                    // start bfs
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        // iterate through dir array to find connected 1s in all direction
                        for (int[] dir : dirs) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                                q.add(new int[] { nr, nc });
                                grid[nr][nc] = '2';
                            }
                        }
                    }

                }

            }
        }
        return count;

    }
}
