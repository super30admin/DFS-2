// Time complexity - O(mxn)
// Space complexity - O(mxn) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public int numIslands(char[][] grid) {
        
         if(grid.length == 0 || grid == null || grid[0].length == 0){
            
            return 0;
        }
        int result = 0;
        int r = grid.length;
        int c = grid[0].length;
       
        Queue<Integer> q1 = new LinkedList<>();
        
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                
                if(grid[i][j] == '1'){
                    result ++;
                    grid[i][j] = '0';
                    dfs(r, c, i, j, grid);
                }
                
            }
        }
        return result;
    }
    private void dfs(int r, int c, int i, int j, char[][] grid){
         int[] dx = new int[]{-1,0,0,1};
         int[] dy = new int[]{0,1,-1,0};
        
                  for(int k = 0; k < 4; k ++){
                        
                         
                    int ndx = i + dx[k];
                    int ndy = j + dy[k];
                
                        if(isValid(r, c, ndx, ndy)){
                           // System.out.println("hitting");
                            if(grid[ndx][ndy] == '1'){
                               
                                grid[ndx][ndy] = '0';
                                dfs(r, c, ndx, ndy, grid);
                            }
                        }
                        
                        
                    }
        
        
    }
   private boolean isValid(int r, int c, int i, int j){
        
        if(i < r && j < c && i > -1 && j > -1){
            
            return true;
        }
        
        return false;
    }
}