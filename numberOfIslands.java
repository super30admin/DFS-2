// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    markIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void markIsland(char[][] mat, int r, int c){
        //base case
        if(r<0 || r>=mat.length || c<0 || c>=mat[0].length || mat[r][c] == '0'){
            return;
        }
        //logic
        //mark 1's in all 4 directions as counted(0)
        int[][] dirs = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
        mat[r][c] = '0';
        for(int dir[]: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            markIsland(mat, nr, nc);
        }
        
    }
}