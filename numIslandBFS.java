// Time Complexity : O(m*n)
// Space Complexity : O(min(m, n))
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
   
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        int m = grid.length, n = grid[0].length;
        int isLandCount = 0;
        int[][] dirs = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    isLandCount++;
                    queue.add(new int[]{i,j});
                    
                    while(!queue.isEmpty()){
                        int[] curr = queue.poll();
                        for(int[] dir: dirs){
                            int r = curr[0]+ dir[0];
                            int c = curr[1]+dir[1];
                            if(r >= 0 && r < m && c >=0 && c < n && grid[r][c] == '1'){
                                grid[r][c] ='0';
                                queue.add(new int[] {r,c});
                            }
                                
                        }
                    }
                }
            }
        }
        return isLandCount;
    }
    
}