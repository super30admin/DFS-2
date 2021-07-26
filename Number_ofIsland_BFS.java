// 200. Number of Islands - https://leetcode.com/problems/number-of-islands/
// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int numIslands(char[][] grid) {
          if(grid==null || grid.length == 0) return 0;
        
        int m = grid.length, n=grid[0].length;
        int islandCount = 0;
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    islandCount++;
                    // grid[i][j]='0';
                    queue.add(new int[]{i, j});
                    
                    while(!queue.isEmpty()){
                        int[] curr = queue.poll();
                        
                        for(int[] dir: dirs){
                            int r = dir[0] + curr[0];
                            int c = dir[1] + curr[1];
                            if(r>=0 && r<m && c>=0 && c<n && grid[r][c]=='1'){
                                grid[r][c] = '0';
                                queue.add(new int[]{r,c});
                            }
                        }
                    }
                }
            }
        }
        return islandCount;
    }
}