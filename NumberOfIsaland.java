/**
 * TC: O(mn) SC : O(mn)
 * Approach : Traverse through the grid and find the land, when encounter land run BFS on that cell and mark all the neighboring connected land.
 *       
 */
class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int island = 0;
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    q.offer(new int[]{i,j});
                    grid[i][j] = '0';
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir:dirs){
                            int r = dir[0] + curr[0];
                            int c = dir[1] + curr[1];
                            if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1'){
                                q.offer(new int[]{r,c});
                                grid[r][c] = '0';
                            }
                        }
                    }
                    island++;
                }
                    
            }
        }
        return island;
    }
}