// Time Complexity : O(N*M)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == '1'){
                    count++;
                    q.add(new int[]{i,j});
                    grid[i][j] = '0';
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        
                        for(int[] dir:dirs){
                            int newI = curr[0]+dir[0];
                            int newJ = curr[1]+dir[1];
                            if(newI >=0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == '1'){
                                q.add(new int[]{newI,newJ});
                                grid[newI][newJ] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
