// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution {
    int[][] dirs;
    int m;
    int n;
    int count;
    public int numIslands(char[][] grid) {
        // base
        if (grid == null || grid.length == 0) return 0;

        m = grid.length;
        n = grid[0].length;
        count = 0;
        dirs = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for (int i=0; i<m; i++) {
            for (int j=0; j<n;j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        // base case
        if (r < 0 || c < 0 || r == m || c == n || Character.compare(grid[r][c],'1') != 0) return;

        // logic
        if (grid[r][c] == '1') {
            grid[r][c] = '0';
            for (int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                dfs(grid, nr, nc);
            }
        }


    }

//     public int numIslands(char[][] grid) {
//         // base
//         if (grid == null || grid.length == 0) return 0;

//         int m = grid.length;
//         int n = grid[0].length;
//         int count = 0;
//         int[][] dirs = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};

//         for (int i=0; i<m; i++) {
//             for (int j=0; j<n;j++) {
//                 if (grid[i][j] == '1') {
//                     grid[i][j] = 0;
//                     count++;
//                     Queue<int[]> queue = new LinkedList<>();
//                     queue.add(new int[] {i, j});
//                     //start bfs
//                     while(!queue.isEmpty()) {
//                         int[] curr = queue.poll();
//                         for (int[] dir : dirs) {
//                             int nr = curr[0] + dir[0];
//                             int nc = curr[1] + dir[1];
//                             if (nr >= 0 && nc >=0 && nr<m && nc<n && grid[nr][nc] == '1') {
//                                 grid[nr][nc] = '0';
//                                 queue.add(new int[] {nr, nc});
//                             }
//                         }
//                     }
//                 }
//             }
//         }

//         return count;
//     }
}
