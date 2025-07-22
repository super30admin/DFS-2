import java.util.LinkedList;
import java.util.Queue;

/*
Approach - BFS
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time Complexity - O(M*N)
Space Complexity - O(M*N)
 */
public class NumberofIslands_LC_200 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        int[][] dirs = {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}}
                ;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n ; j++) {
                if(grid[i][j] == '1'){
                    count++;
                    q.add(i);
                    q.add(j);
                    grid[i][j] = '0';
                    while(!q.isEmpty()) {
                        int cr = q.poll();
                        int cc = q.poll();
                        for(int [] dir : dirs){
                            int nr = dir[0] + cr;
                            int nc = dir[1] + cc;
                            if(nr >= 0 && nc >= 0 && nr <m && nc <  n && grid[nr][nc] == '1'){
                                q.add(nr);
                                q.add(nc);
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

/* Approach DFS
Time Complexity - O(M*N)
Space Complexity - O(M*N)

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null ||grid.length == 0)
            return 0;
        int nr = grid.length;
        int nc = grid[0].length;
        int num_island = 0;
        for(int r =0 ;r<nr; r++){
            for(int c=0; c<nc; c++){
                if(grid[r][c]=='1')
                    num_island++;
                    dfs(grid,r, c);
            }
        }
        return num_island;
    }
        void dfs(char[][] grid,int r, int c){
            int nr = grid.length;
            int nc = grid[0].length;

            if(r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0'){
                return;
            }
            grid[r][c] ='0';
            dfs(grid, r-1,c);
            dfs(grid, r+1, c);
            dfs(grid, r,c-1);
            dfs(grid, r, c+1);
        }
}
*/