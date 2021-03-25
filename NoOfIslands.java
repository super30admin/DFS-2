// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<Integer> q = new LinkedList<>();
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    count ++;
                    q.add(i);
                    q.add(j);
                    grid[i][j] = '0';
                    
                    while(!q.isEmpty()){
                        int cr = q.poll();
                        int cc = q.poll();
                        for(int[] dir : dirs){
                            int r = cr + dir[0];
                            int c = cc + dir[1];
                            if(r>=0 && r<n && c>=0 && c<m && grid[r][c] == '1'){
                                q.add(r);
                                q.add(c);
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