import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {
    //BFS
    // TC : O (m * n)
    // SC : O (Min (m, n))
    // where m = raw and n = column
    public int numIslands(char[][] grid) {
        if (grid == null) return 0;

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        int result = 0;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {
                    que.add(new int[]{i, j});
                    grid[i][j] = '3';
                    while (!que.isEmpty()) {
                        int[] curr = que.poll();
                        for (int[] dir : dirs) {
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1') {
                                grid[r][c] = '3';
                                que.add(new int[]{r, c});
                            }
                        }
                    }
                    result++;
                }
            }
        }
        return result;
    }

    //DFS
    // TC : O (m * n)
    // SC : O (m * n)
    // where m = raw and n = column
    int[][] dirs;
        int m , n ;
        public int numIslands1(char[][] grid) {
            if (grid == null) return 0;

            m = grid.length;
            n = grid[0].length;
            Queue<int[]> que = new LinkedList<>();
            int result = 0;
            dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
            for (int i= 0; i < m ; i ++){
                for (int j= 0; j < n ; j ++){
                    if (grid[i][j] == '1'){
                        dfs (grid, i , j );
                        result ++;
                    }
                }
            }
            return result;
        }
        private void dfs(char[][] grid, int r, int c){
            //base case

            //logic
            grid[r][c] = '3';
            for (int[] dir : dirs){
                int raw = r + dir[0];
                int col = c + dir[1];
                if (raw >=0 && raw < m && col >=0 && col < n && grid[raw][col] == '1'){
                    dfs(grid, raw, col);
                }
            }
        }
}
