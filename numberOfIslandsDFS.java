// Time Complexity: O(m x n)
//Space Complexity: O(m x n)

class Solution {
     int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length; int n = grid[0].length;
        int count = 0;
        dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i< m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int r, int c, int m, int n){
        if(r < 0 || c < 0 || r == m || c == n || grid[r][c] != '1') return;
        
        grid[r][c] = '0';
        for(int[] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(grid, nr,nc,m,n);
        }
        
    }
}