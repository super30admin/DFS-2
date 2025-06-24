// Time complexity - O(n)
//Space - O(1)
// Faced any issues - No
// Solved on leetcode - yes
// Here initially we are adding 1st occurance of '1' to the dfs and then we are making all the contigous 0's to 1. paralley we are updating the count, as well as the visited to 0s
class Solution {
    int count =0;
   int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int numIslands(char[][] grid) {
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    dfs(grid, i,j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int currentRow, int currentColumn) {

        for(int[] dir:dirs) {
            int m = currentRow + dir[0];
            int n = currentColumn + dir[1];
            if (m < 0 || m >= grid.length || n < 0 || n >= grid[0].length) continue;

            if(grid[m][n] == '1') {
                grid[m][n] = '0';
                dfs(grid, m, n);
            }
        }
    }
}
