//Leetcode #200
//S30 #65

// Time Complexity : O(n*m) size of the grid
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*Approach
 * We will be using DFS to solve the problem. Idea is to iterate the entire matrix and if we if '1'
 * then do the DFS starting form that position to its neighbours. Change the value from '1' to '0' once visited
 * */

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        if(grid==null || grid.length==0) return 0;
        int count = 0;
        int m = grid.length, n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid, i ,j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        //base
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length || grid[i][j]!='1' ) return;

        //logic
        grid[i][j] = '0';
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, r, c);
        }
    }

    //using BFS
    public int numIslandsBFS(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int count = 0;

        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

        for(int i=0; i<m; i++){
            for(int j=0; j<n ;j++){
                if(grid[i][j]=='1'){
                    q.offer(new int[]{i,j});
                    grid[i][j]='0';
                    count++;

                    while (!q.isEmpty()){
                        int[] cur = q.poll();
                        for(int [] dir : dirs){
                            int r = cur[0] + dir[0];
                            int c = cur[1] + dir[1];
                            if(r>=0 && r<m && c>=0 && c<n && grid[r][c]=='1'){
                                q.offer(new int[]{r,c});
                                grid[r][c]='0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
