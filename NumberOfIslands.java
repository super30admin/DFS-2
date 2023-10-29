// Time Complexity :O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class NumberOfIslands {
    class Solution {
        private int count;
        int[][] dirs;
        public int numIslands(char[][] grid) {
            int m =  grid.length, n = grid[0].length;

            if(grid == null || m == 0 || n == 0)
                return 0;

            dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            Queue<int[]> q = new LinkedList<>();
            count = 0;

            // for(int i = 0; i < m; i++){
            //     for(int j = 0; j < n; j++){
            //         if(grid[i][j] == '1'){
            //             count++;
            //             q.add(new int[]{i, j});
            //             grid[i][j] = '0';
            //             while(!q.isEmpty()){
            //                 int[] popped = q.poll();
            //                 for(int[] dir : dirs){
            //                     int nr = dir[0] + popped[0];
            //                     int nc = dir[1] + popped[1];

            //                     if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1'){
            //                         grid[nr][nc] = '0';
            //                         q.add(new int[]{nr, nc});
            //                     }
            //                 }
            //             }
            //         }
            //     }
            // }

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == '1'){
                        count++;
                        dfs(grid, m, n, i, j);
                    }
                }
            }
            return count;
        }
        private void dfs(char[][] grid, int m, int n, int i, int j){
            if(i < 0 || i >= m || j < 0|| j >= n || grid[i][j] == '0')
                return;

            grid[i][j] = '0';
            for(int[] dir : dirs){
                int nr = dir[0] + i;
                int nc = dir[1] + j;
                dfs(grid, m, n, nr, nc);
            }
        }
    }
}
