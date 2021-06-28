// Time Complexity : O(N*M)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Perform DFS on the 1's and convert them into 0. After all the adj 1's have bedcome 0 increment the counter and
*/


// Your code here along with comments explaining your approach
class Solution {
    int count = 0;
    int m = 0;
    int  n = 0;
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(int i, int j, char[][] grid) {
        grid[i][j] = '0';
        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if(x>=0 && x<m && y>=0 && y<n && grid[x][y] == '1') {
                dfs(x, y, grid);
            }
        }
    }
}
