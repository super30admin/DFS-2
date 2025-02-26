// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// BFS approach with Queue

class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    grid[i][j] = '0';
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        for (int[] dir : dirs) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];

                            if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
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