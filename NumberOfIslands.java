class Solution {
    // Time Complexity : O(mn), where m is the no of rows and n is the no of columns
    // Space Complexity : O(mn)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    // Approach - Using DFS
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    int r;
    int c;
    public int numIslands(char[][] grid) {
        r = grid.length;
        c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int count = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(visited[i][j] == false && grid[i][j] == '1') {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }


    public void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        for(int[] d : dirs) {
            int nr = i + d[0];
            int nc = j + d[1];
            if(nr >= 0 && nr < r && nc >= 0 && nc < c && !visited[nr][nc] && grid[i][j] == '1') {
                visited[nr][nc] = true;
                dfs(grid, visited, nr, nc);
            }
        }
    }
}