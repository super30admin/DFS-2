// Time Complexity : O(m * n)
// Space Complexity : min(m, n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
Iterate through the input matrix and increment the count of islands when we find '1', simultaneously, push
it into the queue for BFS traversal by visiting the 4 directions of that land/cell and push those further
cells into the queue if they get identified as land and marking them as water/0, such that we dont revisit
them again. Return the final count variable.
 */

class Solution {
    int m, n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(grid[i][j] == '1') {
                    q.add(new int[] {i, j});
                    count++;
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        for(int[] dir : dirs) {
                            int newRow = dir[0] + curr[0];
                            int newCol = dir[1] + curr[1];
                            if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == '1') {
                                grid[newRow][newCol] = '0';
                                q.add(new int[]{newRow, newCol});

                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}