import java.util.LinkedList;
import java.util.Queue;


//DFS
// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
public class NumberOfIslands {
    private int count;
    private int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid.length < 1){
            return 0;
        }

        dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){

                if(grid[i][j] == '1'){
                    count++;
                    //make the connected 1s into 0s
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col){
        if(row <0 || col <0 || row >=grid.length || col >= grid[0].length){
            return;
        }
        if(grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';
        for(int[] dir: dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];
            dfs(grid, nr, nc);
        }
    }

    private void bfs(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        Queue<Integer> q;
        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){

                if(grid[i][j] == '1'){
                    count++;
                    //make the connected 1s into 0s
                    q = new LinkedList<>();
                    q.add(i);
                    q.add(j);
                    grid[i][j] = '0';

                    while(!q.isEmpty()){
                        int row = q.poll();
                        int col = q.poll();

                        for(int[] dir: dirs){
                            int nr = row + dir[0];
                            int nc = col + dir[1];

                            if(nr >=0 && nr <m && nc >=0 && nc < n &&
                                    grid[nr][nc] == '1'){
                                q.add(nr);
                                q.add(nc);
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }
    }
}
//BFS
// Time Complexity : O(m*n)
// Space Complexity :O(min (m, n))
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

class NumberOfIslandsBFS {
    private int count;
    private int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid.length < 1){
            return 0;
        }

        dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        bfs(grid);
        return count;
    }

    private void bfs(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        Queue<Integer> q;
        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){

                if(grid[i][j] == '1'){
                    count++;
                    //make the connected 1s into 0s
                    q = new LinkedList<>();
                    q.add(i);
                    q.add(j);
                    grid[i][j] = '0';

                    while(!q.isEmpty()){
                        int row = q.poll();
                        int col = q.poll();

                        for(int[] dir: dirs){
                            int nr = row + dir[0];
                            int nc = col + dir[1];

                            if(nr >=0 && nr <m && nc >=0 && nc < n &&
                                    grid[nr][nc] == '1'){
                                q.add(nr);
                                q.add(nc);
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }
    }
}
