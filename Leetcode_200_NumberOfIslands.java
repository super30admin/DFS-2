/*approahc - BFS
1. start a for loop and scan the matrix
2. stop where you find 1 , count++ and start BFS there. 
go into all four directions  when grid =='1'
3. change the neighbor found '1' to 0, so they dont be scanned again. 
TC: O(mn)*k for direactions = O(mn)
sc:O(mn) - queue
*/

class Solution {
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';

                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] { i, j });
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();

                        for (int[] dir : dirs) {
                            int nr = dir[0] + curr[0];
                            int nc = dir[1] + curr[1];

                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0';
                                q.add(new int[] { nr, nc });
                            }
                        }
                    }
                }
            }
        }
        return count;

    }
}