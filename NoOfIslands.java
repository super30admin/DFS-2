// Time Complexity : O(mn)
// Space Complexity : O(1) if we ignore DFS stack.
// O(mn) if we consider the stack. It can go as deep as m*n levels
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We will be visiting each element in the matrix, if it is 1, we will run DFS for that element.
//All the visited nodes, if '1', will be marked to '0'.


class Solution {
    int numOfIslands = 0;
    int m;
    int n;
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        m = grid.length;
        n = grid[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1') {
                    numOfIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numOfIslands;
    }


    void dfs(char[][] grid, int r, int c) {

        if(r < 0 || r >=m || c < 0 || c >= n) return;
        if (grid[r][c] != '1') return;

        grid[r][c]  = '0';

        for(int[] dir : dirs) {
            dfs(grid, r+dir[0], c+dir[1]);
        }
    }
}
