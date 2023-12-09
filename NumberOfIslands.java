import java.util.*;

// Time Complexity :O(m*n)
// Space Complexity :O(Math.min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
public class NumberOfIslands {
    //*********************BFS*******************
    public int numIslands(char[][] grid) {
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}}; // to explore all adjacent nodes
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '0';
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir:dirs){
                            int r = dir[0] + curr[0];
                            int c = dir[1] + curr[1];
                            if( r >= 0 && c >= 0 && r<m && c<n && grid[r][c]=='1'){
                                grid[r][c] = '0';
                                q.add(new int[]{r,c});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    // ************************DFS****************
    int[][]dirs;
    int m, n;
    public int numIslands2(char[][] grid) {

// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
        this.dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}}; // to explore all adjacent nodes
        this.m = grid.length;
        this.n = grid[0].length;
        int count = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j){
        grid[i][j]='0';
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] =='1'){
                dfs(grid,r,c);
            }
        }
    }
}
