//TC: O(mxn)
//SC: O(min(m,n))
import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {

    public int numIslands(char[][] grid) {
        final int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;

                    final Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] {i, j});
                    grid[i][j] = '0';


                    while (!queue.isEmpty()) {
                        final int[] current = queue.poll();
                        for (int[] dir: dirs) {
                            final int nr = dir[0] + current[0], nc = dir[1] + current[1];
                            if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0';
                                queue.offer(new int[] {nr, nc});
                            }
                        }
                    }
                }
            }
        }

        return islands;
    }

    public static void main(String[] args) {
        final NoOfIslands noOfIslands = new NoOfIslands();
        char[][] grid = new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(noOfIslands.numIslands(grid));

        grid = new char[][] {
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(noOfIslands.numIslands(grid));
    }
}
