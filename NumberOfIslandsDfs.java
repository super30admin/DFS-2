// Time Complexity : O(m * n)
// Space Complexity : O(m * n)

class Solution {
    int m;
    int n;
    int[][] dirs;
    int count;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        count = 0;
        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j){
        if(i == m || j == n || i < 0 || j < 0 ||  grid[i][j] != '1')
            return;
        grid[i][j] = '0';
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, r, c);
        }
    }
}