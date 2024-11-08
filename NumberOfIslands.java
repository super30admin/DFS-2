// BFS SOlution
// TC: O(mn)
// SC: O(mn)
class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    q.add(new int[]{i,j});
                    grid[i][j] = '0';
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        for(int[] dir : dirs) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                                q.add(new int[]{nr,nc});
                                grid[nr][nc] = '0';
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


// DFS Solution
// TC: O(mn)
// SC: O(min(m,n))
class Solution {
    public int numIslands(char[][] grid) {
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid,i,j,dirs);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col, int[][] dirs) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '0';
        for(int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            dfs(grid, nr, nc, dirs);
        }
    }
}