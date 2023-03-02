// TC: O(m x n)
// SC: O(m x n)

class Solution {
    int m, n;

    int[][] dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n ; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        grid[i][j] = '0';
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] d : dir) {
                int r = d[0] + curr[0];
                int c = d[1] + curr[1];
                if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1') {
                    q.add(new int[] {r, c});
                    grid[r][c] = '0';
                }
            }
        }
    }
}