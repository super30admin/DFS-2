// Time Complexity : O(M+N)
// Space Complexity : O(M+N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    int m,n;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //When we encounter 1 increment the count and check the neighbours
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= m || col >= n || grid[row][col] != '1')
            return;
        
        grid[row][col] = '2';
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int[] dir: dirs){
            int r = row + dir[0];
            int c = col + dir[1];
            dfs(grid, r, c);
        }
    }
}