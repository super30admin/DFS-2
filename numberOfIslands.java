// Time Complexity : O(m*n) where m, n are dimensions of the grid
// Space Complexity : O(min(m,n)) where m, n are dimensions of the grid
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// BFS using queue

class numberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i, j});
                    grid[i][j] = '0';
                    while (!q.isEmpty()) {
                        int curr[] = q.poll();
                        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
                        for (int[] dir : dirs) {
                            int row = dir[0] + curr[0];
                            int col = dir[1] + curr[1];
                            if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == '1') {
                                q.add(new int[] {row, col});
                                grid[row][col] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}