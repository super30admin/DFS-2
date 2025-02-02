// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

// BFS, TC = O(m * n), SC = O(m + n)
// class Solution {
//     int[][] dirs;
//     public int numIslands(char[][] grid) {
//         // null
//         if(grid == null || grid.length == 0) return 0;
//         dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//         int m = grid.length;
//         int n = grid[0].length;
//         int count = 0;
//         Queue<Integer> rq = new LinkedList<>();
//         Queue<Integer> cq = new LinkedList<>();
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 if(grid[i][j] == '1') {
//                     count++;
//                     rq.add(i); cq.add(j);
//                     grid[i][j]='0';//mark as visited before pushing to q always to prevent duplicates
//                     while(!rq.isEmpty()) {
//                         int cr = rq.poll();
//                         int cc = cq.poll();
//                         for(int[] dir: dirs) {
//                             int nr = cr + dir[0];
//                             int nc = cc + dir[1];
//                             // bound check
//                             if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
//                                 grid[nr][nc] = '0'; //mark as visited before pushing to q always to prevent duplicates being pushed
//                                 rq.add(nr); cq.add(nc);
//                             }
//                         }
//                     }
//                 }
//             }
//         }
//         return count;
//     }
// }

// DFS: Connected Components, TC: O(M * N), SC: O(M * N)
class Solution {
    int[][] dirs;
    public int numIslands(char[][] grid) {
        // null
        if(grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j <n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j, int m, int n) {
        // base
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0') return;
        // logic
        grid[i][j] ='0'; // marking as visited
        for(int[] dir: dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, r, c, m, n);
        }
    }
}