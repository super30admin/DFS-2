// Time Complexity: O(m*n)
// Space Complexity: O(1)

// Using a counter for no of islands, we perform dfs on the first 1 we see. We mutate the array and mark visited areas as 2, and add neighboring values of the island to stack and continue.



class Solution {
    private int ROWS, COLS;
    public int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        ROWS=grid.length;
        COLS=grid[0].length;
        if (grid == null || ROWS == 0) {
            return 0;
        }
        
        int numofIslands = 0;

        for (int i=0; i<ROWS; i++) {
            for (int j=0; j<COLS; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    numofIslands++;
                }
            }
        }

        return numofIslands;
    }

    public void dfs(char[][] grid, int i, int j) {
        for (int[] dir : dirs) {
            int nr = dir[0] + i;
            int nc = dir[1] + j;

            if (nr>=0 && nr<ROWS && nc>=0 && nc<COLS && grid[nr][nc] == '1') {
                grid[nr][nc] = '2';
                dfs(grid, nr, nc);    
            }

        }
    }

    public void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        grid[i][j] = '2';
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] index = queue.poll();
            for (int[] dir : dirs) {
                int nr = dir[0] + index[0];
                int nc = dir[1] + index[1];

                if (nr>=0 && nr<ROWS && nc>=0 && nc<COLS && grid[nr][nc] == '1') {
                    grid[nr][nc] = '2';
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        
    }
}
