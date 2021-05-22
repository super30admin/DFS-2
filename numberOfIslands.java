// Time complexity - O(mxn)
// Space complexity - O(minimum of(m,n) 
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
        int[] dx = new int[]{-1,0,0,1};
        int[] dy = new int[]{0,1,-1,0};
        Queue<Integer> q1 = new LinkedList<>();
        
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                
                if(grid[i][j] == '1'){
                    result ++;
                    grid[i][j] = '0';
                    q1.add(i);
                    q1.add(j);
                }
                
                while(!q1.isEmpty()){
                    
                    int currX = q1.poll();
                    int currY = q1.poll();
                    
                    for(int k = 0; k < 4; k ++){
                        
                         
                    int ndx = currX + dx[k];
                    int ndy = currY + dy[k];
                
                        if(isValid(r, c, ndx, ndy)){
                           // System.out.println("hitting");
                            if(grid[ndx][ndy] == '1'){
                               
                                grid[ndx][ndy] = '0';
                                q1.add(ndx);
                                q1.add(ndy);
                            }
                        }
                        
                        
                    }
                   
                }
            }
        }
        return result;
    }
    
   private boolean isValid(int r, int c, int i, int j){
        
        if(i < r && j < c && i > -1 && j > -1){
            
            return true;
        }
        
        return false;
    }
}