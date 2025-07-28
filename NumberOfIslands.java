//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        int dirs[][] = new int [][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    cnt++;
                    dfs(grid, i, j, dirs);
                }

            }
        }
        return cnt;
    }
    private void dfs(char[][]grid, int r, int c, int dirs[][]){
        if(r<0 || c<0 || r== grid.length || c== grid[0].length|| grid[r][c] == '0') return;
        grid[r][c] = '0';
        for(int [] dir:dirs){
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            dfs(grid, nr, nc, dirs);
        }
    }
}
