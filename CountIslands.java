package S30.DFS_2;

/*BFS Solution
Time Complexity : O(MxN)
Space Complexity :O(min(M,N))
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

/*DFS Solution
Time Complexity : O(MxN)
Space Complexity : O(MxN)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

import java.util.LinkedList;
import java.util.Queue;

public class CountIslands {

    int R;
    int C;
    int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};

    //BFS Solution
    public int numIslandsBFS(char[][] grid) {

        this.R = grid.length;
        if(R == 0) return 0;
        this.C = grid[0].length;
        int count = 0;

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(grid[i][j] == '1'){
                    count++;
                    bfs(i,j,grid);
                }
            }
        }

        return count;

    }

    private void bfs(int r, int c, char[][] grid){
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{r,c});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] dir : dirs){
                int row = curr[0] + dir[0];
                int col = curr[1] + dir[1];
                if(row >= 0 && col >= 0 && row < R && col < C && grid[row][col] == '1'){
                    grid[row][col] = '0'; // sink the island
                    queue.offer(new int[]{row,col});
                }
            }
        }
    }

    //DFS Solution
    public int numIslandsDFS(char[][] grid) {

        this.R = grid.length;
        if(R == 0) return 0;
        this.C = grid[0].length;
        int count = 0;

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(i,j,grid);
                }
            }
        }

        return count;
    }

    private void dfs(int r, int c, char[][] grid){

        if(r < 0 || c < 0 || r >= R || c >= C || grid[r][c] == '0') return;
        grid[r][c] = '0'; //sink the island
        for(int[] dir : dirs){
            int row = r + dir[0];
            int col = c + dir[1];
            dfs(row,col,grid);
        }
    }
}
