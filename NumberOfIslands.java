import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
       NumberOfIslands obj = new NumberOfIslands();
       int obj1 = obj.numIslands(grid);
       System.out.println(obj1);

    }

    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][] { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    q = new LinkedList<>();
                    q.add(new int[] { i, j });
                    grid[i][j] = '0';
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int[] dir : dirs) {
                            int nr = cur[0] + dir[0];
                            int nc = cur[1] + dir[1];

                            if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
                                q.add(new int[] { nr, nc });
                                grid[nr][nc] = '0';
                            }

                        }
                    }

                }

            }
        }
        return count;

    }
}