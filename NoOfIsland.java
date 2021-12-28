/*
TC: O(m x n)
SC: min(m, n) https://imgur.com/gallery/M58OKvB
*/
class Solution {
    int[][] dirs;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;

        int noOfIsland = 0;
        dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m ; j++) {
                if(grid[i][j] == '1') {
                    noOfIsland++;
                    queue.add(new int[]{i, j});
                    grid[i][j] = '0';
                    while(!queue.isEmpty()) {
                        int[] popped = queue.poll();

                        for(int[] dir : dirs) {
                            int nr = popped[0] + dir[0];
                            int nc = popped[1] + dir[1];

                            if(nr >= 0 && nr < grid.length && nc >=0 && nc < grid[0].length && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0';
                                queue.add(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }

        return noOfIsland;
    }

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';

        for(int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];

            if(nr >= 0 && nr < grid.length && nc >=0 && nc < grid[0].length && grid[nr][nc] == '1') {
                dfs(grid, nr, nc);
            }
        }
    }
}