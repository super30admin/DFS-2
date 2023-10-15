/* 

## Problem1 (https://leetcode.com/problems/number-of-islands/)

Time Complexity : O(m*n)
Space Complexity : O(m+n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

*/

class Solution {
    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        for(int i = 0; i < m; i++){
            for(int j= 0; j< n; j++){
                if(grid[i][j] == '1'){
                    total++;
                    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};    
                    Queue<int[]> q = new LinkedList<int[]>();
                    q.add(new int[]{i,j});
                    grid[i][j] = 2;
                    while(!q.isEmpty()){
                        int[] index = q.poll();
                        for(int[] dir : dirs){
                            int nr = index[0] + dir[0];
                            int nc = index[1] + dir[1];           
                            if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                                if(grid[nr][nc] == '1'){
                                    grid[nr][nc] = '2';
                                    q.add(new int[] {nr,nc});
                                }
                            }  
                        }
                    }
                }
            }
        }
        return total;
    }
}