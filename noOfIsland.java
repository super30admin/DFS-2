class noOfIsland {

    // DFS TC:O(m*n) SC: O(m * n))
    int[][] dirs;
    int m, n;

    public int numIslands(char[][] grid) {
        // null
        if (grid == null || grid.length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
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

    private void dfs(char[][] grid, int i, int j) {
        // base
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j] != '1')
            return;

        // logic
        grid[i][j] = 0;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, r, c);
        }

    }
}

// //BFS TC:O(m*n) SC: O(min(m,n))
// public int numIslands(char[][] grid) {
// //null
// if(grid == null || grid.length == 0) return 0;
// int m = grid.length; int n = grid[0].length;
// int [][] dirs = new int [][] {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
// int count = 0;
// Queue<int []> q = new LinkedList<>();
// for(int i = 0; i < m; i++){
// for(int j = 0; j < n; j++){
// if(grid[i][j] == '1'){
// count++;
// grid[i][j] = 0;
// q.add(new int[] {i, j});
// while(!q.isEmpty()){
// int [] curr = q.poll();
// for(int [] dir: dirs) {
// int r = dir[0] + curr[0];
// int c = dir[1] + curr[1];
// if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1'){
// grid[r][c] = 0;
// q.add(new int[] {r, c});
// }
// }
// }
// }
// }
// }

// return count;

// }