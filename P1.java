/*
BFS 

TC - O(m x n) 
SC - O(m x n)
 */

 class Solution {
    public int numIslands(char[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      int count = 0;
      int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

      for (int i = 0; i < m; i ++) {
        for (int j = 0; j < n; j ++) {
            if (grid[i][j] == '1') {
                count ++;

                //bfs
                Queue<int []>  q = new LinkedList<>();
                q.add(new int[] {i, j});
                grid[i][j] = '0';
                while(!q.isEmpty()) {
                    int[] curr = q.poll();
                    for (int[] dir : dirs) {
                        int nr = dir[0] + curr[0];
                        int nc = dir[1] + curr[1];
                        if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                            q.add(new int[]{nr, nc});
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