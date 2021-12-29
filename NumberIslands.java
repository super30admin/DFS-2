// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach BFS

// We loop through the matrix and whereever we encounter 1 we put that in the queue and start bfs
// increment the count
// We make it 0
// We pop the queue and then add all the nodes having 1 to the queue and repeat the process

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    count++;
                    q.add(new int[] { i, j });
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        for (int[] dir : dirs) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if (nr >= 0 && nc >= 0 && nc < n && nr < m && grid[nr][nc] == '1') {
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
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach DFS

// Used a recursive approach
// we loop through the matrix and where ever we find one we increment the count
// and start the dfs from that point
// We look into the four directions and make the 1 into 0
// while we are within the bounds we do this recursively

class Solution {
    int m, n;
    int[][] dirs;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
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

    public void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r == m || c == n || grid[r][c] == '0')
            return;
        grid[r][c] = '0';
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(grid, nr, nc);
        }
    }
}