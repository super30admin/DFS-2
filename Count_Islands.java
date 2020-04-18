// Time Complexity :O(mxn)
// Space Complexity :O(mxn)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int numIslands(char[][] grid) {
      if(grid==null||grid.length==0||grid[0].length==0){
          return 0;
      }
        int count=0;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    checkVisited(grid,i,j,m,n);
                }
                
            }
        }
        return count;
    }
    
    public void checkVisited(char[][] grid, int i, int j, int m, int n){
        if(grid[i][j]!='1'){
            return;
        }
        
        grid[i][j]='2';
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int[] dir: dirs){
            int r = dir[0]+i;
            int c = dir[1]+j;
            
            if(r>=0 && r<m && c>=0 && c<n){
                checkVisited(grid,r,c,m,n);
            }
        }
    }
}