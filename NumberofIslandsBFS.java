/*
* Approach:
*  1. Iterate over grid for "1". If found, start BFS from that point.
        Add neighbors with "1" into queue and convert them it to "0".
* 
*  2. Once queue is empty, BFS stops and considered as one island.
    Again iterate over grid and find "1" and apply BFS.
* 
*  3. Continue this until all elements in grid are "0". finally, return islands.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O((m*n)*(m*n))
    m*n - iterating over grid
    m*n - in queue
* 
* Space Complexity: O(m*n)
    m*n - in queue
* 
*/

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslandsBFS {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        int islands = 0;

        Queue<Integer> queue = new LinkedList<>();

        int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == '1') {
                    queue.add(row);
                    queue.add(col);
                    grid[row][col] = '0';

                    while (!queue.isEmpty()) {
                        int r = queue.poll();

                        int c = queue.poll();

                        for (int[] dir : directions) {
                            int nr = r + dir[0];
                            int nc = c + dir[1];

                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                                queue.add(nr);
                                queue.add(nc);

                                grid[nr][nc] = '0';
                            }
                        }
                    }

                    islands++;
                }
            }
        }

        return islands;
    }
}
