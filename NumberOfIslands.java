import java.util.Queue;

public class NumberOfIslands {
    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    int m, n;

    public int numIslands(char[][] grid) {
        // iterate over the grid
        // check for 1 - land

        // put it in q, change it to 2 and \
        // start the bfs
        m = grid.length;
        n = grid[0].length;
        Queue<Pair<Integer, Integer>> q = new java.util.LinkedList<>();
        int numOfIsland = 0;
        if (grid == null || grid.length == 0)
            return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    q.add(new Pair<Integer, Integer>(i, j));
                    grid[i][j] = '2';
                    bfs(q, i, j, grid);
                    numOfIsland++;
                }
            }
        }
        return numOfIsland;
    }

    private void bfs(Queue<Pair<Integer, Integer>> q, int row, int col, char[][] grid) {
        while (!q.isEmpty()) {
            Pair<Integer, Integer> current = q.poll();
            for (int[] dir : dirs) {
                int nr = current.getKey() + dir[0];
                int nc = current.getValue() + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                    q.add(new Pair<Integer, Integer>(nr, nc));
                    grid[nr][nc] = '2';
                }
            }
        }
    }
}
