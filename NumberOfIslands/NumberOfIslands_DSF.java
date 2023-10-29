/* Time Complexity : O(m*n) 
 *  m - rows of the matrix - grid
 *  n - cols of the matrix - grid */
/* Space Complexity : O(m*n)
 *  (m*n) => max number of elements that could be present in the queue at any any given point of time*/
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//DFS solution

class Solution {
    int m;
    int n;
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};//right,left,down,up
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        //Traverse through the grid and find the position where whe have '1'
        //increment the island count and change the original value at that position to '0' so that we do not count it again.
        //call dfs function to perform the same operation by checking in all 4 directions
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    //System.out.println("i: " + i + " j: " + j + " count: " + count);
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c){
        //base condition
        if(r < 0 || r == m || c < 0 || c == n || grid[r][c] != '1') return;
        //logic
        grid[r][c] = '0';
        for(int[] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(grid, nr, nc);
        }
    }
}