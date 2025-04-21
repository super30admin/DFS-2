import java.util.LinkedList;
import java.util.Queue;

//Approach 1: BFS -> TC: O(m*n), SC: O(min(m,n))
public class NumberOfIslands {
    int[][] dirs;
    int m, n;

    public int numIslands(char[][] grid) {
        this.dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        this.m = grid.length;
        this.n = grid[0].length;
        int count = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0'; //marking as visited

                    q.add(new int[]{i, j});

                    while (!q.isEmpty()) {
                        int[] curr = q.poll();

                        for (int[] dir : dirs) {
                            int r = dir[0] + curr[0];
                            int c = dir[1] + curr[1];

                            if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1') {
                                q.add(new int[]{r, c});
                                grid[r][c] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}


//Approach -2 : DFS
class Solution {
    int[][] dirs;
    int m, n, count;

    public int numIslands(char[][] grid) {
        this.dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        this.m = grid.length;
        this.n = grid[0].length;
        this.count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;
            if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1') {
                dfs(grid, r, c);
            }
        }
    }
}

//TC: O(m*n), SC: O(m*n)
