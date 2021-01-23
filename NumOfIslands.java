//Problem : 66 -Number of Islands
// Time Complexity : //DFS : TC: O(2m*n)=>O(m*n), m stands for rows and n stands for columns in grid. Here 2mn because we will be touching each element at the time of DFS/BFS and at the time of iterating over array.
                    //BFS : TC: O(m*n)
// Space Complexity : //DFS : SC: O(m*n)
                      //BFS :   SC: O(min(m,n)). Note: Draw the matrix and explore it using BFS, u will understand
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
  As there are connected components it can Be done Using DFS or BFS. TC for both will be same but SC for BFS will be better
  DFS/BFS: Just iterate over the and whenever u found 1 increment the count and then do DFS/BFS. While doing DFS/BFS make sure all visited paths are converted to 0, so that they won't be traversed again.

*/
import java.util.*;
class Solution66 {

    public int numIslands(char[][] grid) {
       
        //DFS : TC: O(m*n) | SC: O(m*n)
        //BFS : TC: O(m*n) | SC: O(min(m,n))
        
       if(grid==null || grid.length==0) return 0;
       int count = 0;
       for(int i=0;i<grid.length;i++){
           for(int j=0;j<grid[0].length;j++){
               
               if(grid[i][j]=='1'){
                   count++;
                   grid[i][j] = '0';
                   //dfs(grid,i,j);
                   bfs(grid,i,j);
               }
               
           }
       }
       
       return count;
   }
   
   //DFS
   private void dfs(char[][] grid,int i, int j){
       
       int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
       
       for(int[] dir:dirs){
           
           int r = i+ dir[0];
           int c = j+ dir[1];
           
           if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]=='1'){
               grid[r][c] = 0;
               dfs(grid,r,c);
           }
           
       }
       
   }
   
   private void bfs(char[][] grid,int i, int j){
       
       Queue<int[]> q = new LinkedList<>();
       q.offer(new int[]{i,j});
       
       int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};
       
       while(!q.isEmpty()){
           int[] curr = q.poll();
          
           for(int[] dir : dirs){
             int r = curr[0]+dir[0];
             int c = curr[1]+dir[1];
               
             if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]=='1'){
                 grid[r][c] = '0';
                 q.offer(new int[]{r,c});
             }  
               
           }
       
       }
       
   }
   
   
}