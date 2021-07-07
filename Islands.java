import java.util.Queue;
// Time Complexity : O(N) for DFS AND BFS
// Space Complexity : O(N) for DFS AND BFS
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    int dirs [][] = {{0,1},{0,-1},{1,0},{-1,0}};
    
     boolean isDFS = true;
     public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0||grid[0].length==0)
         return 0;
         int count  =0;
         if(!isDFS){
          int r ,c;
         r = grid.length;
         c = grid[0].length;
         for(int i =0; i < r; i++){
             for(int j =0; j < c; j++){
                 if(grid[i][j] == '1'){
                     count++;
                     dfs(grid,i,j);
                 }
             }
         }
         }
         
         int r,c;
         r = grid.length;
         c = grid[0].length;
         for(int i =0; i < r; i++){
             for(int j =0; j < c; j++){
                 if(grid[i][j] == '1'){
                     count++;
                     Queue<int []> queue = new LinkedList<>();
                     queue.add(new int[]{i,j});
                     while(!queue.isEmpty()){
                         int []chain = queue.remove();
                         for(int dir[] : dirs){
                             int newRow = chain[0] + dir[0];
                             int newCol = chain[1] + dir[1];
                             if(newRow >= 0 && newRow < r && newCol >= 0 && newCol < c && grid[newRow][newCol] == '1'){
                                 grid[newRow][newCol] = '0';
                                 queue.add(new int[]{newRow,newCol});
                             }
                         }
 
                     }
                 }
             }
         }
         return count++;
     }
     
     public void dfs(char grid[][],int i,int j){
         int m=grid.length;
     int n=grid[0].length;
  
     if(i<0||i>=m||j<0||j>=n||grid[i][j]!='1')
         return;
         grid[i][j] = '0';
         for(int dir[] :  dirs){
             int newRow = i + dir[0];
             int newCol = j + dir[1];
             dfs(grid,newRow,newCol);
         }
         
     }
 }