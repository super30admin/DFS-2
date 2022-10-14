class Solution {
    public int numIslands(char[][] grid) {
        // T.C : 0 (m * n)
        // S.C : O(m * n)
        // Executed
        if (grid == null || grid.length == 0)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        for (int[] dir : dirs) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            while (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc]=='1') {
                                grid[nr][nc] = '0';
                                q.add(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}