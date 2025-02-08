import java.util.LinkedList;
import java.util.Queue;

// TC: O(m * n) in the worst case of traversing all the elements in the matrix.
// SC: O(m * n) will be the size of queue elements offered and polled
public class NumberofIslands {

    public static void main(String[] args) {
        System.out.println(numIslandsUsingBFS(new String[][] { { "1", "1", "1", "1", "0" },
                { "1", "1", "0", "1", "0" },
                { "1", "1", "0", "0", "0" },
                { "0", "0", "0", "0", "0" } }));
        System.out.println(numIslandsUsingBFS(new String[][] { { "1", "1", "0", "0", "0" },
                { "1", "1", "0", "0", "0" },
                { "0", "0", "1", "0", "0" },
                { "0", "0", "0", "1", "1" } }));

        System.out.println(numIslandsUsingDFS(new String[][] { { "1", "1", "1", "1", "0" },
                { "1", "1", "0", "1", "0" },
                { "1", "1", "0", "0", "0" },
                { "0", "0", "0", "0", "0" } }));
        System.out.println(numIslandsUsingDFS(new String[][] { { "1", "1", "0", "0", "0" },
                { "1", "1", "0", "0", "0" },
                { "0", "0", "1", "0", "0" },
                { "0", "0", "0", "1", "1" } }));
    }

    public static int numIslandsUsingBFS(String[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } }; // U D L R
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j].equals("1")) {
                    islands++;
                    grid[i][j] = "2";
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[] { i, j });
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        for (int[] dir : dirs) {
                            int nr = dir[0] + curr[0];
                            int nc = dir[1] + curr[1];
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc].equals("1")) {
                                q.offer(new int[] { nr, nc });
                                grid[nr][nc] = "2";
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }

    static int[][] dirs;
    static int m, n;

    public static int numIslandsUsingDFS(String[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        int islands = 0;
        dirs = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } }; // U D L R
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j].equals("1")) {
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }
        return islands;
    }

    private static void dfs(String[][] grid, int i, int j) {
        // base
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || !grid[i][j].equals("1")) {
            return;
        }
        // logic
        grid[i][j] = "2";
        for (int[] dir : dirs) {
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            dfs(grid, nr, nc);
        }
    }

}