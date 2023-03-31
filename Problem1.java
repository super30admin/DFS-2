// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* If element at grid = 1, call recursive function dfs. 
Increase count and add element's neighbors until neighbors finish and reset elements value to 0. 
Once done, check if any other elements in the grid are 1 and do the same thing. 
 * 
 */

class Problem1 {
      public int numIslands(char[][] grid) {
            int m = grid.length; 
            int n = grid[0].length; 
            int dirs[][] = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
            int count = 0; 
            for(int i = 0; i < m ; i++){
                for(int j = 0; j < n ; j++){
                    if(grid[i][j] == '1'){
                        count++;
                        dfs(grid,i,j,dirs,m,n);
                    }
                }
            }
            return count;
             }
             private void dfs(char grid[][], int i, int j, int dirs[][], int m, int n){
                 if (i < 0 || j < 0 || i == m || j == n|| grid[i][j] == '0'){
                     return;
                 }
                 grid[i][j] ='0';
                 for(int[] dir: dirs){
                     int r = dir[0] + i;
                     int c = dir[1] + j;
                     dfs(grid,r,c,dirs,m,n);
                 }
             }
       }