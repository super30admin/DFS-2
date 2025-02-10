
/**
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public int numIslandsWithBFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Queue<int[]> queue = new LinkedList<>();
                    grid[i][j] = '2';
                    queue.add(new int[] { i, j });
                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        for (int[] dir : dirs) {
                            int nr = dir[0] + current[0];
                            int nc = dir[1] + current[1];
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                                queue.add(new int[] { nr, nc });
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