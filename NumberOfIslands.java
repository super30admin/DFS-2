// Time Complexity : O(mn)
// Space Complexity : DFS: (O(mn)), BFS: O(min(m, n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class NumberOfIslands {
    int total = 0;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        dirs = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};

        //dfs
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1') {
                    total++;
                    //make the grid value as 0 since it is connected
                    grid[i][j] = '0';

                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});

                    //travel all 4 dirs and modify the connected element value if it is '1' and add to queue
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        for(int[] dir: dirs){
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if(nr >= 0 && nc >= 0 && nr < row && nc < col && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0';
                                q.add(new int[]{nr, nc});
                            }
                        }
                    }
                    //dfs(grid, i, j);
                }
            }
        }
        return total;
    }

//     private void dfs(char[][] grid, int r, int c) {
//         //base case, check the boundaries and check if it's an island(value 1)
//         if(r < 0 || r == grid.length || c < 0 || c == grid[0].length || grid[r][c] != '1') return;

//         //logic
//         //make the grid value as 0 since it is connected
//         grid[r][c] = '0';

//         //travel all 4 dirs and modify the connected element value if it is '1'
//         for(int[] dir: dirs) {
//             int nr = r + dir[0];
//             int nc = c + dir[1];
//             dfs(grid, nr, nc);
//         }
//     }


}