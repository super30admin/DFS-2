import java.util.*;

class Solution {
    /*
        TC - O(n * m)
        SC - avg case - O(min(m, n)) worst case - O(m * n)
        This solution uses BFS to count the number of islands in the grid.
        It scans every cell in the grid. Whenever it finds an unvisited land cell ('1'), 
        it has discovered a new island, so it increments the count and starts a BFS from that cell. 
        During the BFS, all connected land cells are marked as '0' (visited) so they won't be 
        counted again. Each BFS completely explores one island before moving on.
    */
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    q.add(i);
                    q.add(j);
                    grid[i][j] = '0';
                    while (!q.isEmpty()) {
                        int r = q.poll();
                        int c = q.poll();
                        for (int[] dir : dirs) {
                            int nr = r + dir[0];
                            int nc = c + dir[1];
                            if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0';
                                q.add(nr);
                                q.add(nc);
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}