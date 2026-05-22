// Time Complexity : O(m*n)
// Space Complexity : O(m*n)

class Solution {
    public int numIslands(char[][] grid) {
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    q.offer(new int[]{i,j});

                    while(!q.isEmpty()) {
                        int size = q.size();
                        for(int k = 0; k < size; k++) {
                            int[] curr = q.poll();
                            for(int[] dir: dirs) {
                                int r = dir[0] + curr[0];
                                int c = dir[1] + curr[1];

                                if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1') {
                                    q.offer(new int[]{r,c});
                                    grid[r][c] = '0';
                                }
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}