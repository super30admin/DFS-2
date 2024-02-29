// https://leetcode.com/problems/number-of-islands/
// Time Complexity: O(m * n)
// Space Complexity: O(m * n)

class Solution {
    int m;
    int n;
    int[][] dirs;

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        this.m = grid.length;
        this.n = grid[0].length;
        this.dirs = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        int count = 0;
        // Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    // count++;
                    // q.add(i);
                    // q.add(j);
                    // grid[i][j] = '0';
                    // while(!q.isEmpty()) {
                    //     int sr = q.poll();
                    //     int sc = q.poll();
                    //     for(int[] dir: dirs) {
                    //         int nr = dir[0] + sr;
                    //         int nc = dir[1] + sc;
                    //         if(nr >= 0 && nc >= 0 && nr < m && nc < n &&
                    //         grid[nr][nc] == '1'){
                    //             q.add(nr);
                    //             q.add(nc);
                    //             grid[nr][nc] = '0';
                    //         }
                    //     }
                    // }
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        //base
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0') return;

        //logic
        grid[i][j] = '0';
        for(int[] dir: dirs) {
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            dfs(grid, nr, nc);
        }
    }
}