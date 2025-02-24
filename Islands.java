// Time Complexity: O(m*n) where m is the number of rows and n is the number of columns
// Space Complexity: O(m*n) where m is the number of rows and n is the number of columns for DFS. For BFS, O(min(m,n)) where m is the number of rows and n is the number of columns
// Did this code successfully run on Leetcode : Yes



import java.util.LinkedList;
import java.util.Queue;

class Islands {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, m , n);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col, int m, int n){
        // base
        if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != '1'){
            return;
        }

        // logic
        grid[row][col] = '2';
        for(int[] dir: dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];

            dfs(grid, nr, nc, m, n);
        }

    }

    // BFS
    public int numIslandsBFS(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int count = 0;

        Queue<int[]> queue = new LinkedList<>();


        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    queue.add(new int[]{i, j});
                    grid[i][j] = '0';

                    while(!queue.isEmpty()){
                        int[] elem = queue.poll();

                        for(int[] dir: dirs){
                            int nr = elem[0] + dir[0];
                            int nc = elem[1] + dir[1];

                            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1'){
                                queue.add(new int[]{nr, nc});
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
