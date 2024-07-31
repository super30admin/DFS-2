// Time Complexity : O(2(m*n)) ~ O(m*n)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//BFS
class NumberOfIslands {
    int[][] dirs;
    public int numIslands(char[][] grid) {
        this.dirs = new int[][]{{-1,0},{0,1},{0,-1},{1,0}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    queue.add(new int[]{i,j});
                    while(!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        for(int[] dir : dirs) {
                            int nr = curr[0]+dir[0];
                            int nc = curr[1]+dir[1];
                            if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0';
                                queue.add(new int[]{nr,nc});
                            }
                        }
                    }
                    
                }
            }
        }
        return count;
        
    }
}
// Time Complexity : O(2(m*n)) ~ O(m*n)
// Space Complexity : O(m*n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//DFS
class NumberOfIslands {
    int[][] dirs;
    int m;
    int n;
    public int numIslands(char[][] grid) {
        this.dirs = new int[][]{{-1,0},{0,1},{0,-1},{1,0}};
        this.m = grid.length;
        this.n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i , int j) {
        grid[i][j] = '0';
        for(int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                dfs(grid, nr, nc);
            }
        }
    }
}