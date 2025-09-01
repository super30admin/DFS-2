// Time Complexity : O(m * n) — each cell is visited at most once
// Space Complexity : O(m * n) in the worst case (queue can hold many land cells in a large island)
// Did this code successfully run on Leetcode : Yes

// Approach:
// 1. Scan the grid. When you find '1', that's a new island: increment count, flip it to '0', and BFS from there.
// 2. Standard 4-direction BFS: pop a cell, visit valid '1' neighbors, mark them '0', and enqueue.
// 3. Mutating the grid serves as a visited marker; no extra visited array needed.
// 4. Continue until all cells are processed; the count is the number of islands.


import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        int count = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '0';
                    q.add(new int[]{i, j});

                    while(!q.isEmpty()){
                        int[] curr = q.poll();

                        for(int[] dir : dirs){
                            int r = dir[0] + curr[0];
                            int c = dir[1] + curr[1];

                            if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1'){
                                grid[r][c] = '0';
                                q.add(new int[]{r, c});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
