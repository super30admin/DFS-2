// Time Complexity : O(m * n)
// Space Complexity : O(min(m, n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No major issues, just careful boundary checks

// Approach:
// Traverse the grid and start BFS when unvisited land ('1') is found, marking it as visited.
// During BFS, explore all 4 directions and mark connected lands as visited.
// Each BFS traversal counts as one island, so increment the count accordingly.


import java.util.*;

public class numberOfIslands  
{
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '2';
                    q.offer(new int[]{i, j});
                    count++;

                    while (!q.isEmpty()) {
                        int[] cell = q.poll();
                        int x = cell[0], y = cell[1];
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            grid[x - 1][y] = '2';
                            q.offer(new int[]{x - 1, y});
                        }
                        if (x + 1 < rows && grid[x + 1][y] == '1') {
                            grid[x + 1][y] = '2';
                            q.offer(new int[]{x + 1, y});
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            grid[x][y - 1] = '2';
                            q.offer(new int[]{x, y - 1});
                        }
                        if (y + 1 < cols && grid[x][y + 1] == '1') {
                            grid[x][y + 1] = '2';
                            q.offer(new int[]{x, y + 1});
                        }
                    }
                }
            }
        }

        return count;
    }
}
