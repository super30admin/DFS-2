// tc: o(mn)
// sc: o(mn)

class Solution {
    int count;
    int m, n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        //BFS
        // base case
        if(grid == null || grid.length == 0) return 0;

        // row, column
        m = grid.length;
        n = grid[0].length;

        // diections array, up, down , right, left
        dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    // queue
                    Queue<int[]> q = new LinkedList<>();
                    grid[i][j] = '0';
                    q.add(new int[]{i, j});
                    // start bfs
                    while(!q.isEmpty()){
                        int [] curr = q.poll();
                        for(int [] dir: dirs){
                            int nr = dir[0] + curr[0];
                            int nc = dir[1] + curr[1];
                            if(nr>=0 && nr< m && nc>= 0 && nc<n && grid[nr][nc] == '1'){
                                q.add(new int[]{nr, nc});
                                grid[nr][nc] = '1';
                            }


                        }
                    }
                }
            }
        }
        return count;

    }

}


























// // tc: o(mn)
// // sc: o(mn)

// class Solution {
//     int count;
//     int m, n;
//     int[][] dirs;
//     public int numIslands(char[][] grid) {
//       //DFS
//       // base case
//        if(grid == null || grid.length == 0) return 0;

//         // row, column
//          m = grid.length;
//          n = grid[0].length;

//         // diections array, up, down , right, left
//          dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

//         for(int i = 0; i < m; i++){
//             for(int j = 0; j < n; j++){
//                 if(grid[i][j] == '1'){
//                     count++;
//                  dfs(i, j, grid);
//                 }

//             }
//         }
//         return count;

//     }
//     private void dfs(int r, int c, char[][] grid){
//         // base case
//         if(r < 0 || r == m || c < 0 || c == n || grid[r][c] != '1') return;

//         // logic
//         grid[r][c] = '0';
//         for(int[] dir: dirs){

//             int nr = dir[0] + r;
//             int nc = dir[1] + c;
//             dfs(nr, nc, grid);
//         }

//     }
// }