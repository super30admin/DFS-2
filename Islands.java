import java.util.LinkedList;
import java.util.Queue;

// SC :O(min(M,N)) because in worst case where the grid is filled with lands,the size of queue can grow up to min(M,NM,N).
// TC : O(M*N) where M is the number of rows and N is the number of columns
public class Islands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int count = 0;
        int m = grid.length, n = grid[0].length;
        Queue<int[]> land = new LinkedList<>();
        int[][] dirs = new int[][] { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    land.add(new int[] { i, j });
                    grid[i][j] = '2';
                    count++;
                    while (!land.isEmpty()) {
                        int[] curr = land.poll();
                        for (int[] dir : dirs) {
                            int nr = dir[0] + curr[0];
                            int nc = dir[1] + curr[1];
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                                grid[nr][nc] = '2';
                                land.add(new int[] { nr, nc });
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
