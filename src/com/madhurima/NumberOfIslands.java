// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
package com.madhurima;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
}

class SolutionNumberOfIslandsDFS {
    int m,n;
    int[][] dirs;
    //dfs
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        m = grid.length;
        n = grid[0].length;
        int count = 0;
        dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col){
        //base
        if(row < 0 || row == m || col < 0 || col == n || grid[row][col] != '1'){
            return;
        }

        //logic
        grid[row][col] = '0';
        for(int[] dir: dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];
            dfs(grid, nr, nc);
        }

    }

}

class SolutionNumberOfIslandsBFS {
    //bfs
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    grid[i][j] = '0';
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir: dirs){
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if(nr >= 0 && nr < m && nc >=0 && nc < n && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                q.add(new int[]{nr,nc});
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}