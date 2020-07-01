// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes						
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach


class Solution {
     int[][] dirs; 
     int count;
     int m;
     int n;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
           return 0;
        dirs = new int[][] {{-1,0},{1,0},{0,-1},{0,1}}; 
         m = grid.length;
         n = grid[0].length;
         Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ; i < m ; i++ ){
            for(int j = 0 ; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
        
      
    }
    
    private void dfs(char[][] grid,int sr ,int sc ){
        if(sr >=m || sr < 0 || sc < 0 || sc >=n || grid[sr][sc] == '0')
            return;
        grid[sr][sc] = '0';    
        for(int[] dir : dirs){
            int r = sr + dir[0];
            int c = sc + dir[1];
            dfs(grid,r,c);            
        }    
    }
        

       
    }
    
  
    
    
