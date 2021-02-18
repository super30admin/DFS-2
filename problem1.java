// Time Complexity :O(n*m)
// Space Complexity :O(number of islands*size of islands)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int numIslands(char[][] grid) {
        int out=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    DFS(grid,i,j);
                    out++;
                }
                
            }
        }
        return out;
    }
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public void DFS(char[][] grid, int i, int j){
         if(i>=0 && j>=0 && i<grid.length && j< grid[0].length && grid[i][j]=='1'){
                grid[i][j]='0';//marking 0 for any island which is the neighbour of starting point.
                for(int[] dir : directions){
                    int x= i+dir[0];
                    int y= j+ dir[1];
                    DFS(grid,x,y);
                }
            }
            else return;
        
    }
}