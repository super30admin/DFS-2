//Iterative or BFS

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] dirs = {{0,1}, {-1, 0}, {0, -1}, {1, 0}};
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == '1') {
                    q.add(new int[]{i, j});
                    grid[i][j] = '0';
                    count++;
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();

                        for(int[] dir : dirs) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc] == '1'){
                                q.add(new int[] {nr, nc});
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

//Recurrsive or DFS

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class Solution {
    int[][] dirs;
    int count, m, n;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        m = grid.length;
        n = grid[0].length;
        dirs = new int[][] {{0,1}, {-1, 0}, {0, -1}, {1, 0}};

        for(int i = 0; i< m; i++) {
            for(int j =0 ; j<n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        //base
        if(r<0 || c<0 || r==m || c==n || grid[r][c] != '1') return;
        //logic
        grid[r][c] = '0';
        for(int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            dfs(grid, nr, nc);
        }
    }
}