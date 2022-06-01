//BFS Solution
// Time Complexity: O(mn)
//Space Complexity: O(min(m,n))
// Did this code successfully run on Leetcode : Yes


import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        //null case
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<int []> q = new LinkedList<>();
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    q.add(new int[] {i, j});
                    grid[i][j] = '2';
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        for(int[] dir: dirs) {
                            int r = dir[0] + curr[0];
                            int c = dir[1] + curr[1];
                            if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1') {
                                q.add(new int[] {r,c});
                                grid[r][c] = '2';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
