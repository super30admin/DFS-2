// Time Complexity : O(m*n ) where m is no of rows and n is columns
// Space Complexity : O(min(m,n)) 
// Did this code successfully run on Leetcode : yes


// approach : Implemented bfs by making continuous 1's as 0's and then calculating that single iteration as count of 1. Similarly we will loop through entire grid

class Solution {
    public int numIslands(char[][] grid) {
        
        if(grid == null)
            return 0;
        
        int numOfIslands = 0;
        int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    numOfIslands++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i,j});
                    grid[i][j] = '0';
                    while(!queue.isEmpty()){
                        int[] current = queue.poll();
                        
                        for(int[] d : dir){
                            int r = current[0]+d[0];
                            int c = current[1]+d[1];
                            
                            if(!(r<0 || r == grid.length || c <0 || c == grid[0].length || grid[r][c] == '0')){
                                queue.add(new int[]{r,c});
                                grid[r][c] = '0';
                                
                            }
                                
                        
                        }
                    }
                }
            }
        }
        
        return numOfIslands;
        
    }
    

}