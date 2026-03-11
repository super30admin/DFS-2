import java.util.*;

// BFS O(n * m) time, O(n * m) space
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = new int[][] {
            {0,1},{1,0},{-1,0},{0,-1}
        };

        Queue<int[]> q = new LinkedList<>();

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    q.offer(new int[] {i,j});
                    grid[i][j] = '0'; // mark visited

                    while (!q.isEmpty()) {
                        int[] curr = q.poll();

                        for (int[] dir : dirs) {
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];

                            if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == '1') {
                                grid[r][c] = '0';
                                q.offer(new int[]{r, c});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}