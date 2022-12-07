
//sc is O(mxn)
//T is O(mxn)
import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // start bfs
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] { i, j });
                    grid[i][j] = 0;
                    count++;

                    while (!q.isEmpty()) {
                        int[] curr = q.poll();

                        for (int[] dir : dirs) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];

                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                                grid[nr][nc] = 0;
                                q.add(new int[] { nr, nc });
                            }
                        }

                    }

                }
            }
        }
        return count;

    }
}