// Time Complexity : O(m*n)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package dfs2;

import java.util.*;

public class IslandsBFS {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> c = new LinkedList<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length, n = grid[0].length, count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    r.add(i);
                    c.add(j);
                    while (!r.isEmpty()) {
                        int cr = r.poll();
                        int cc = c.poll();
                        for (int dir[] : dirs) {
                            int nr = cr + dir[0];
                            int nc = cc + dir[1];
                            if (nr >= 0 && nc >= 0 && nr < m
                                    && nc < n && grid[nr][nc] == '1') {
                                r.add(nr);
                                c.add(nc);
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

}
