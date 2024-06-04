// Time Complexity : m*n
// Space Complexity : DFS- m*n ; BFS min(m,n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn.

/*Problem# 200
 * BFS & DFS
 * find the element that has the '1', begin the island and count as 1 & using BFS or DFS make all the neighbour elements as '0' and move forward with the next 
 * until we find the next '1' which is the next island
 * 
 * BFS - uses Queue (LinkedList)
 * DFS - uses Recurssion or Stack 
 */

import java.util.*;

public class NumberOfIslands {

    int[][] directions;

    // BFS
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        this.directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int count = 0;
        // BFS
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    queue.add(new int[] { i, j });
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        for (int[] dir : directions) {
                            int nR = dir[0] + curr[0];
                            int nC = dir[1] + curr[1];
                            if (nR >= 0 && nC >= 0 && nR < m && nC < n && grid[nR][nC] == '1') {
                                grid[nR][nC] = '0';
                                queue.add(new int[] { nR, nC });
                            }
                        }
                    }
                }
            }
        }
        return count;

    }

    int n;
    int m;

    // DFS
    public int numIslands_dfs(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int count = 0;
        // BFS

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;

    }

    public void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for (int[] dir : directions) {
            int nR = dir[0] + i;
            int nC = dir[1] + j;
            if (nR >= 0 && nC >= 0 && nR < m && nC < n && grid[nR][nC] == '1') {
                dfs(grid, nR, nC);
            }
        }
    }

}