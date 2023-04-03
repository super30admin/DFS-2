import java.util.LinkedList;
import java.util.Queue;
//Leetcode - 200
//TC - O(2M*N)
//SC - O(M*N)
public class NoOfIslands {
    //BFS
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j < n; j++) {//O(M*N)
                if(grid[i][j] == '1') {
                    count++;
                    q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    grid[i][j] = 0;
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        for(int[] dir : dirs) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if(nr >=0 && nc>=0 && nr<m && nc <n && grid[nr][nc] == '1') {
                                q.add(new int[]{nr,nc});
                                grid[nr][nc] = 0;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    //DFS
    /*int count;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        for(int i=0; i<m; i++) {
            for(int j =0;j <n; j++) {
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, dirs, m, n);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j, int[][] dirs, int m, int n) {
        //base
        if(i<0 || j<0 || i == m || j == n || grid[i][j] == '0') return;
        //logic
        grid[i][j] = '0';
        for(int[] dir : dirs) {
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            dfs(grid, nr, nc, dirs, m, n);
        }
    }*/
}
