// Time Complexity : O(m*n) 
// Space Complexity :O(m*n) 
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/number-of-islands/solutions/3811433/java-super-simple-dfs-solution/
// Any problem you faced while coding this : No


class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
       
       int numIslands=0;

       for(int i=0;i<grid.length;i++){
           for(int j=0;j<grid[i].length;j++){
               numIslands += dfs(grid,i,j);
           }
       }
       return numIslands;
    }

    public static int dfs(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]=='0'){
            return 0;
        }

           grid[i][j] = '0';
           dfs(grid,i+1,j);
           dfs(grid,i-1,j);
           dfs(grid,i,j+1);
            dfs(grid,i,j-1);

           return 1; 

    }
}
