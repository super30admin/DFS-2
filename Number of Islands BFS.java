// Time Complexity : O(m*n); where m = numnber of rows and n = number of columns in the input matrix
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // int[][] dirs;
    // int count;
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][] {{0,1},{-1,0},{0,-1},{1,0}};
        int count = 0;
        
        Queue<int[]> q = new LinkedList<>();
        
        // traverse through the grid matrix
        for(int i = 0; i < m; i++){
            for(int j= 0 ; j < n; j++){
                // if 1 is found, increae the count of island 
                if(grid[i][j] == '1'){
                    count++;
                    
                    // and add the element to the queue and mark it as 0 in the grid matrix since it has already been counted
                    q.add(new int[]{i, j});
                    grid[i][j] = '0';

                    // process the queue until it's empty
                    while(!q.isEmpty()){
                        // take the first element of the queue
                        int[] curr  = q.poll();
                        
                        // process the neighbors
                        for(int[] dir : dirs){
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            
                            // check the bounds and whether neighbor is 1
                            if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1'){
                                // if neighbor is 1, then add it to the queue and mark it as 0 in the grid matrix
                                q.add(new int[]{r, c});
                                grid[r][c] = '0';
                            }
                        }
                    }
                }
            }
        }
         return count;
    }
}