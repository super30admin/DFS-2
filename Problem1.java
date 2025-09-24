// Time Complexity :  O(m × n)
// Space Complexity : O(m × n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
We perform bfs traversal and visit all 1's and once visited add to the queue and mark it visited
Check for the neighbors and if it is a land perform same and increement the count of islands;
*/
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};

        int count = 0;
        
        for(int i = 0;i<m;i++) {
            for (int j=0;j<n;j++){
                if(grid[i][j] == '1') {
                    count++;
                    Queue<int[]> q= new LinkedList();
                    q.add(new int[]{i,j});
                    grid[i][j] = '0';

                    while(!q.isEmpty()) {
                        int[] cur = q.poll();
                        for(int[] dir: dirs) {
                            int nr = dir[0] + cur[0];
                            int nc = dir[1] + cur[1];

                            if(nr >= 0 && nc>=0 && nr <m && nc< n && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0';
                                q.add(new int[]{nr, nc});
                            }
                        }
                    }

                }
            }
        }
      
        return count;
        
    }
}
