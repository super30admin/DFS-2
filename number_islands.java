/**
 * Time: O(m*n) m, n - length of rows and colns of the given input matrix grid
 * Space: O(m*n) - stack size
 */
class Solution {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1')
                {
                    cnt++;
                    dfs(grid,i,j);
                }
            }
        }
        return cnt;
    }
    private void dfs(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0') return;
        for(int[] dir: dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            grid[i][j] = '0';
            dfs(grid,r,c);
        }
    }
}