//---------------------BFS---------------------------------------------
// Time Complexity :O(nm)+O(nm)===O(mn)
// Space Complexity :min of m and n
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//we are going to each element and doing bfs on each element having value 1 and marking visited elements as 2.
//after end of every BFS, we know that there are no neighbours having value 1 so we know that we came at boundaries of island
//so we inc our count by 1
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    q.add(new int[] { i, j });
                    grid[i][j] = '2';
                    while (!q.isEmpty()) {
                        int[] loc = q.poll();
                        int r = loc[0];
                        int c = loc[1];
                        for (int[] dir : dirs) {
                            int nr = dir[0] + r;
                            int nc = dir[1] + c;
                            if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
                                q.add(new int[] { nr, nc });
                                grid[nr][nc] = '2';
                            }
                        }
                    }
                    count++;
                }
            }
        }

        return count;
    }
}

// ----------------------------DFS-----------------------------
// Time Complexity :O(mn)+O(mn)
// Space Complexity :number of elements in largest island===O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

// we'll do dfs on each element having value 1.during dfs we do recursive call
// for each element having value1
// after every dfs call in main method, we increase the count and return the
// coutn at end
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, m, n, i, j, dirs);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int m, int n, int i, int j, int[][] dirs) {
        // base case
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1')
            return;
        // logic
        grid[i][j] = '2';
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            dfs(grid, m, n, nr, nc, dirs);
        }

    }
}