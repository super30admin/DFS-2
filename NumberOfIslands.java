class Solution {
		/*
     * Time Complexity: O(m*n) visiting all elements
     * Space Complexity: O(m*n) for visited boolean array
     */
    int count;
    int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    boolean[][] visited;
    int row, col;
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null) return 0;
        // logic - dfs
        row = grid.length;
        col = grid[0].length;
        visited = new boolean[row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        // base case
        if (i < 0 || i >= row || j < 0 || j >= col) return;
        if (visited[i][j] || grid[i][j] != '1') return;
        // logic
        visited[i][j] = true;
        for (int[] dir: dirs) {
            dfs(grid, i+dir[0], j+dir[1], visited);
        }
    }
}
