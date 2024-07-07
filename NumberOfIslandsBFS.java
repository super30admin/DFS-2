// Time Complexity : O(m*n) => As we start bfs only when we encounter 1 even if the entire grid matrix is filled with 1, we only perform BFS once
// Space Complexity : O(m*n) // As we are using queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach : Using BFS. Start iterating over gird matrix and soon as 1st 1 is discovered
convert its value to 2 to avoid processing that cell again and add in the queue. Then run while loop until queue is not empty and then travel all 4 directions and if 1 is discovered add in the queue and again convert it's value to 2
 */
class Solution {
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    Queue<int[]> q = new LinkedList<>();
                    count++;
                    grid[i][j] = '2';
                    q.add(new int[] { i, j });

                    while (!q.isEmpty()) {
                        int curr[] = q.poll();

                        for (int[] dir : dirs) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];

                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                                q.add(new int[] { nr, nc });
                                grid[nr][nc] = '2';

                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}