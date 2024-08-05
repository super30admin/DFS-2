// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int[][] dirs = new int[][]{{0,1}, {1, 0}, {0, -1}, {-1, 0}};
    int m;
    int n;
    private void dfs(char[][] grid, int r, int c){
        if(grid[r][c] == '0' || grid[r][c] == '2') return;
        grid[r][c] = '2';
        for(int i=0;i<dirs.length;i++){
            int nr = r + dirs[i][0];
            int nc = c + dirs[i][1];
            if(nr >= 0 && nc >=0 && nr < m && nc <n){
                dfs(grid, nr, nc);
            }
        }
        return;
    }
    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        //int[][] myGrid = new int[m][n];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
}
