/* Time Complexity : O(m*n) 
 *  m - rows of the matrix - grid
 *  n - cols of the matrix - grid */
/* Space Complexity : O(min(m,n))
 *  min(m,n) => max number of elements that could be present in the queue at any any given point of time*/
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//BFS solution

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};//right,left,down,up
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        //Traverse through the grid and find the position where whe have '1'
        //increment the island count and change the original value at that position to '0' so that we do not count it again.
        //also add to queue, till queue is not empty perform the same operation by checking in all 4 directions
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    //System.out.println("i: " + i + " j: " + j + " count: " + count);
                    q.add(new int[]{i,j});
                    grid[i][j] = '0';
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir: dirs){
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1'){
                                q.add(new int[]{nr,nc});
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}