// Time Complexity :
DFS - O(M*N) M = no.of rows in grid and N=no.of columns in grid
// Space Complexity :
DFS - O(M*N) M = no.of rows in grid and N=no.of columns in grid when the matrix has all 1
// Did this code successfully run on Leetcode :
Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


//DFS

class Solution {
    public int numIslands(char[][] grid) {
        
        //Define basecase
        if(grid == null || grid.length == 0) return 0;
        
        //define result
        int result = 0;
        
        //traverse through matrix and find the 1's
        
        for(int i = 0;i< grid.length;i++){
            for(int j = 0; j < grid[0].length ; j++){
                if(grid[i][j] == '1'){
                    result = result + helper(grid, i, j);
                }
            }
        }
        
        return result;
        
    }
    
    
    private int helper(char[][] grid, int i, int j){
        //sanity checks
        if(i < 0 || i >= grid.length || j < 0 || j  >= grid[0].length || grid[i][j] == '0'){
            return 0;
        }
        
        //mark the current element as visited by changing 1 to 0;
        grid[i][j] = '0';
        
        //call helper function recursively on all 4 directions
        helper(grid, i+1, j);
        helper(grid, i-1, j);
        helper(grid, i, j+1);
        helper(grid, i, j-1);
        
        return 1;
        
    }
}


==============================================================
//BFS APPROACH

class Solution {
    public int numIslands(char[][] grid) {
        
        //BFS
        
        //Edge case
        if(grid == null || grid.length == 0) return 0;
        
        int result = 0;
        
        //Queue for BFS
        Queue<int []> q = new LinkedList<>();
        
    
        
        for(int i=0; i< grid.length ; i++){
            for(int j = 0; j< grid[0].length ; j++){
                if(grid[i][j] == '1'){
                   result ++ ;
                   //mark it as visited
                   grid [i][j] = '0';
                   q.offer(new int[]{i,j});
                   
                    
                }
          
        //Define directions array 
        int [] [] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        
        //apply BFS
        while(!q.isEmpty()){
            int size = q.size();
           
            for(int k =0;k< size; k++){
                //poll from queue    
                int [] x = q.poll();
                int x1 = x[0];
                int x2 = x[1];
                //traverse through the valid directions
                for(int[] direction : directions){
                    int newx1 = direction[0] + x1;
                    int newx2 = direction[1] + x2;
                    
                    if(newx1 < 0 || newx1 >= grid.length || newx2 < 0 || newx2 >= grid[0].length || grid[newx1][newx2] == '0'){
                        continue;
                    }
                    
                   
                    q.offer(new int [] {newx1,newx2});
                    grid[newx1][newx2] = '0';
                }
            }
        }
                
                  }
        }
        
        
     return result;
        
    }
}