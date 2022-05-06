// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
                
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dirs = new int[][] {
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0},
        };
        
        int numOfIslands = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    queue.add(new Pair(i, j));
                    numOfIslands++;
                    
                    // BFS
                    while(!queue.isEmpty()) {
                        Pair<Integer, Integer> cell = queue.poll();
                        int row = cell.getKey();
                        int col = cell.getValue();

                        for(int[]  dir: dirs) {
                            int newRow = row + dir[0];
                            int newCol = col + dir[1];

                            if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && grid[newRow][newCol] == '1') {
                                grid[newRow][newCol] = '0';
                                queue.add(new Pair(newRow, newCol));
                            }
                        }
                    }
                }
            }
        }
        return numOfIslands;
    }
}
