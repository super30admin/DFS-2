//TC: O(n)
//SC: O(n)
//approach: iterating over matrix,
// doing bfs everytime an island is encountered to make sure that land item is not counted in any other island

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int result = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    result++;
                    bfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private void bfs(char[][] grid, int row, int column){
        int[][] dirs = new int[][]{{-1,0}, {1, 0}, {0,-1}, {0,1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, column});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int newRow = dir[0] + curr[0];
                int newCol = dir[1] + curr[1];
                if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && grid[newRow][newCol] == '1'){
                    q.add(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0';
                }
            }
        }
    }
}
