//Time Complexity - O(m*n)
//Space Complexity - O(m*n)
class Solution {
    int m;
    int n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}}; // UDLR
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);

                }
            }
        }
    
    return count;
    }
    private void dfs(char[][] grid, int row, int col){
        if(row < 0 || row == m || col < 0 || col == n || grid[row][col] != '1'){
            return;
        }
        grid[row][col] = '2';
        for(int[] dir : dirs){
            int nr = dir[0] + row;
            int nc = dir[1] + col;
            dfs(grid,nr,nc);
        }

    }
}
