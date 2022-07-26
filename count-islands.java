//TC: O(m*n)
//SC: O(m*n)
class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // U D L R
    int m;
    int n;
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid == null) return 0;
        
        //DFS
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == '1') {
                    grid[i][j] = 0;
                    count++;
                    queue.add(new int[] {i, j});
                    while(!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        for(int[] dir : dirs) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
                                grid[nr][nc] = 0;
                                queue.add(new int[] {nr, nc});
                            }
                        }
                    }
                    // dfs(i, j, grid);
                }
                // System.out.print(grid[i][j]);
            }
        }
        return count;
    }
    
    // public void dfs(int row, int col, char[][] grid) {
    //     grid[row][col] = '0';
    //     for(int[] dir : dirs) {
    //         int nr = row + dir[0];
    //         int nc = col + dir[1];
    //         if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
    //             dfs(nr, nc, grid);
    //         }
    //     }
    // }
}
