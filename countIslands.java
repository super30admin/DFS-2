//time O(mn)
//space O(mn)

class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int count = 1;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                char c = grid[i][j];
                if(c == '1') {
                    count++;
                    dfs(grid, i, j, count);
                }
            }
        }
        return count - 1;
    }
    
    private void dfs(char[][] grider, int i, int j, int count) {
        //base
        if(i >= grider.length || i < 0 || j >= grider[0].length || j < 0 || grider[i][j] != '1') return;
        
        //logic
        grider[i][j] = '0';
        for(int[] dir: dirs) {
            // int nr = dir[0] + i;
            // int nc = dir[1] + j;
            dfs(grider, dir[0] + i, dir[1] + j, count);
        }
    }
}
