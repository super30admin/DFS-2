/** Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
* TC O(M×N) and SC  O(min(M, N))
*/
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int count = 0;
        int m = grid.length, n = grid[0].length;
        Queue<int[]> land = new LinkedList<>();
        int[][]dirs = new int[][]{{0,-1}, {-1,0}, {1,0}, {0,1}};
        for (int i = 0; i< m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    land.add(new int[]{i,j});
                    count++;
                    grid[i][j] = '2';
                    while(!land.isEmpty()) {
                        int []curr = land.poll();
                        for (int[] dir : dirs) {
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            if (r >= 0 && r< m && c >=0 && c < n && grid[r][c] == '1') {
                                land.add(new int[]{r,c});
                                grid[r][c] = '2';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
