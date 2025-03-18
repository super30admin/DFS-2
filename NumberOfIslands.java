// In this problem we are traversing through the grid and if '1' found, changing it's value to 2, so that we can know it is already visited and then starting a 
// BFS/DFS from that island. Locating all the connected '1's by looking U D L R, and putting in queue. So, the number of times we do the BFS/DFS will give us the 
// total number of islands.

// Time Complexity : O(m*n)
// Space Complexity : O(m+n) for BFS and O(m*n) for DFS
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// BFS solution:
class Solution {
    public int numIslands(char[][] grid) {
        // Base case
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        // Count variable for counting number of islands
        int count = 0;
        // Dirs array for looking U D L R
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        // Traverse through the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Locate '1'
                if (grid[i][j] == '1') {
                    // Increase the count
                    count++;
                    // And declare a queue for bfs
                    Queue<int[]> q = new LinkedList<>();
                    // Add the starting '1' to the queue
                    q.add(new int[] { i, j });
                    // Change it's value to 2
                    grid[i][j] = '2';
                    // Loop till queue is empty
                    while (!q.isEmpty()) {
                        // Poll the indices of the current '1'
                        int[] curr = q.poll();
                        // Look at it's adjacent cell
                        for (int[] dir : dirs) {
                            // Calc the position of that adjacent cell
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            // Check if it is a valid cell and it is '1'
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                                // If yes than add it to the queue and change it's value to '2'
                                q.add(new int[] { nr, nc });
                                grid[nr][nc] = '2';
                            }
                        }
                    }

                }

            }
        }
        // Return count
        return count;
    }
}

// DFS solution:
class Solution {
    // Declare this in global scope so we can access them in DFS function
    int m, n;
    int[][] dirs;

    public int numIslands(char[][] grid) {
        // Base case
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        // Count variable for counting number of islands
        int count = 0;
        // Dirs array for looking U D L R
        dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        // Traverse through the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Locate '1'
                if (grid[i][j] == '1') {
                    // Increase the count
                    count++;
                    // Call dfs
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        // Base
        // Check if it's a valid cell and check if it's value is '1'
        if (row < 0 || row == m || col < 0 || col == n || grid[row][col] != '1') {
            return;
        }
        // Logic
        // change the value to 2
        grid[row][col] = '2';
        // Look in 4 directions
        for (int[] dir : dirs) {
            // Calc the new row and new col indice
            int nr = row + dir[0];
            int nc = col + dir[1];
            // Call dfs for that cell
            dfs(grid, nr, nc);
        }
    }
}