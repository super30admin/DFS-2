// Time Complexity : O(m * n) --> where m and n are lengths of input 2D matrix
// Space Complexity : O (min (m , n))
// Did this code successfully run on Leetcode (200): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int dirs[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int []> q = new LinkedList<>();
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    q.add(new int[]{i, j});
                    
                    while (!q.isEmpty()) {
                        int curr[] = q.poll();
                        for (int dir[] : dirs) {
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            
                            if (r >=0 && r < m && c >= 0 && c < n && grid[r][c] == '1') {
                                grid[r][c] = '0';
                                q.add(new int[]{r, c});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}