// approch 1 BFS
// Time Complexity : O(m*n)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2 DFS
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {
    // approch 1 BFS
    public static int numIslands1(char[][] grid) {
        // null case
        if (grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        // direction array
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        // queue for BFS
        Queue<int[]> q = new LinkedList<>();

        // traverse through matrix and whenever we find one we find adjacent element
        // that is one and get further
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if found 1 we increase the count and make it zero as we want to make it as
                // visited
                if (grid[i][j] == '1') {
                    count++;
                    q.add(new int[] { i, j });
                    grid[i][j] = '0';
                    // use bfs queue for exploring adjacent 1 connected to this 1
                    while (!q.isEmpty()) {
                        // Here I am using BFS traversal to get all adjacent 1 and make it visited
                        int[] curr = q.poll();

                        for (int[] dir : dirs) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            // check bound and check adjacent element is one then add into BFS queue
                            if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0';
                                q.add(new int[] { nr, nc });
                            }
                        }

                    }

                }
            }
        }
        // return count
        return count;
    }

    // ====================== approch 2 DFS==============

    private static int count;
    private static int[][] dirs;

    public static int numIslands2(char[][] grid) {
        // null case
        if (grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        count = 0;
        // direction array
        dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        // if we found 1 at any index We are going DFS traversal on all adjacent
        // elements
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // when we found 1 count++ and dfs traversal
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j, int m, int n) {
        // base case
        if (grid[i][j] == '0')
            return;

        // main logic
        // make visited
        grid[i][j] = '0';
        // check in all direction
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            // check bound
            if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                // explore adjacent elements
                dfs(grid, nr, nc, m, n);
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println(numIslands1(grid));
        grid = new char[][] {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println(numIslands2(grid));

    }
}