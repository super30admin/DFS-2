package DFS2;

import java.util.LinkedList;
import java.util.Queue;

public class question66_NumberOfIslands {
    /* Created by palak on 6/26/2021 */

    /*
        Connected Components. We will prefer DFS
        Time Complexity: O(m * n)
        Space Complexity: O(m * n)
    */
    int dirs[][];
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;

        dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        int count = 0;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0; j < n ; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int r, int c, int m, int n) {
        //Base
        if(r < 0 || c < 0 || r == m || c == n || grid[r][c] != '1') return;
        //Logic
        grid[r][c] = '0';
        for(int[] dir: dirs) {
            int row = dir[0] + r;
            int col = dir[1] + c;
            dfs(grid, row, col, m, n);
        }
    }


    /*
        Connected Components. We will prefer DFS/ BFS
        BFS:
        Time Complexity: O(m * n)
        Space Complexity: O(m * n)
    */
    int dirs1[][];
    public int numIslandsBFS(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;

        dirs1 = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0; j < n ; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    queue.add(new int[] {i, j});
                    while(!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        for(int dir[]: dirs1) {
                            int nr = dir[0] + curr[0];
                            int nc = dir[1] + curr[1];
                            if(nr >= 0 && nc >= 0 && nr < m && nc<n && grid[nr][nc]=='1') {
                                grid[nr][nc] = '0';
                                queue.add(new int[] {nr, nc});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
