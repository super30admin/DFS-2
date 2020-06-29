// Time Complexity :O(m*n)
// Space Complexity :O(k) where k is Min(m,n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 )return 0;
        Queue<int []> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i = 0 ; i< m ; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j]=='1'){
                    count++;
                    q.add(new int [] {i,j});
                    while(!q.isEmpty()){
                        int [] curr = q.poll();
                        for(int [] dir :dirs){                        
                            int h = dir[0] + curr[0];
                            int c = dir[1] + curr[1];
                            if(h >= 0 && h < m && c >= 0 && c < n && grid[h][c]=='1'){
                                grid[h][c] = '0';
                                q.add(new int [] {h,c});
                            }
                            
                        }
                    }
                    
                }
            }
           
        } return count;
    }
}
