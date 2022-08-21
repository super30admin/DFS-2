// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
 * BFS solution
 * Iterate over the 2-D matrix and for each 1s encountered --> increase island, we enqueue all the connected 1s 
 * At the end, we will have all the connected 1s count.
 */


class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    grid[i][j] = '2';
                    
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        
                        for (int[] dir: dirs) {
                            int row = curr[0] + dir[0];
                            int col = curr[1] + dir[1];
                            
                            if (row >= 0 && row < m && col >=0 && col < n && grid[row][col] == '1') {
                                q.add(new int[]{row,col});
                                grid[row][col] = '2';
                            }
                        }
                    }
                }
            }
        }
        
        return islands;
    }
}