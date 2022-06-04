// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int[][] dirs = new int[][] { {-1,0}, {0,-1}, {0,1},{1,0}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    queue.add(new int[]{i,j});
                    grid[i][j] = '2';
                    while(!queue.isEmpty()){
                        int[] curr = queue.poll();
                        for(int[] dir : dirs){
                            int r = dir[0] + curr[0];
                            int c = dir[1] + curr[1];
                            if(r>= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1'){
                                queue.add(new int[]{r,c});
                                grid[r][c] = 2;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
