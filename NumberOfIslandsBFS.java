// BFS

// TC: O(m x n)
// SC: O(min(m, n))
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int i, j, m, n, count;
        m = grid.length;
        n = grid[0].length;
        count = 0;
        Queue<int[]> q = new LinkedList<>();
        for(i = 0; i < m; i++) {
            for(j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    q.add(new int[] {i, j});
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        for(int[] d : dirs) {
                            int r = curr[0] + d[0];
                            int c = curr[1] + d[1];
                            if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1') {
                                q.add(new int[] {r, c});
                                grid[r][c] = '#';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}