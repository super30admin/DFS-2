//TC: O(m*n)
//SC: O(m*n)
class Solution {
    int m; int n;
    public int numIslands(char[][] grid) {
        m = grid.length; n = grid[0].length;
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }
    
    private void dfs(char [][] grid, int i, int j){
        //base
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
        //logic
        grid[i][j] = '0';
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            
            if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1'){
                dfs(grid, r, c);
            }
        }
    }
}
