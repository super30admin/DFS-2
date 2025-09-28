// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    int[][] dirs;
    int m,n;

    public int numIslands(char[][] grid) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m = grid.length;
        this.n = grid[0].length;
        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j){

        if(i <0 || j<0 || i == m || j == n || grid[i][j] != '1') return;

        grid[i][j] = '0';
        for(int[] dir: dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;

            dfs(grid, r, c);

        }
    }
}
