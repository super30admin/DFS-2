// TC : O(m*n)
// SC : O(m*n)
// BFS

class Solution {
    
    private boolean check(int m, int n, int nr, int nc) {
        if(nr < m && nr >=0 && nc < n && nc >= 0)
            return true;
        return false;
    }
    
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        
        Queue<int[]> q = new LinkedList<>();
        int result = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    result++;
                    q.add(new int[]{i,j});
                        while(!q.isEmpty()) {
                            int[] temp = q.poll();
                            for(int[] dir : dirs) {
                                int nr = temp[0] + dir[0];
                                int nc = temp[1] + dir[1];
                                if(check(m,n,nr,nc) && grid[nr][nc] == '1') {
                                    grid[nr][nc] = '0';
                                    q.add(new int[]{nr, nc});
                                }
                            }
                        }
                }
                
            }
        }
        return result;
    }
}
