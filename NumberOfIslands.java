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