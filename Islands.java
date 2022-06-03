// Time Complexity : O(m*n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes
class Solution {
    public int numIslands(char[][] grid) {
        int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0}, {1,0}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int []> q = new LinkedList<>();
        int count =0;
        for(int i =0; i<m ; i++){
            for(int j =0 ; j<n ; j++){
                if(grid[i][j] == '1'){
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] rc = q.poll();
                        for(int[] dir : dirs){
                            int r = dir[0]+rc[0];
                            int c =dir[1]+rc[1];
                            if(r>=0 && r<m && c>=0 && c<n && grid[r][c]=='1'){
                                q.add(new int[]{r,c});
                                grid[r][c] = 'N';
                            }
                        }
                        
                        
                    }
                    count++;
                }
            }
        }
        
        return count;
    }
}