// Time Complexity :O(2mn)
// Space Complexity : O(mn)

class Solution {
    int[][] dirs;
    int m;
    int n;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
         m = grid.length ;  n = grid[0].length;
        int numIslands = 0;
        dirs = new int[][]{{0,1}, {0, -1}, {1,0}, {-1,0}};
        for(int i = 0 ; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i , j);
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, int r, int c){
        //base case
        if(r >= m || c >= n || r < 0 || c < 0 || grid[r][c] == '0')
            return ;

        // logic
        grid[r][c] = '0';
        for(int[] dir: dirs){
            dfs(grid, r + dir[0], c + dir[1]);
        }

    }
}
