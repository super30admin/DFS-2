// Approach : Using DFS with Recursion
// Time : O(m*n)
// Space : O(m*n) // worst case filled with all lands then recursion stack has all 1's
class Solution {
    int count;
    int m;
    int n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        this.count = 0;
        this.m = grid.length;
        this.n = grid[0].length;
        this.dirs = new int[][] { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,int i , int j){
        // Base case
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] == '0') return;

        grid[i][j] ='0';

        // logic
        for(int[] dir: dirs){
            int nr = i+ dir[0];
            int nc = j+ dir[1];
             dfs(grid,nr,nc);
        }
    }
}

// Approach : Using BFS with Queue
// Time : O(m*n) + O(m*n)
// Space : O(m*n)
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][] { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = 0;
                    q.add(new int[] { i, j });
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        for (int[] dir : dirs) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
                                q.add(new int[] { nr, nc });
                                grid[nr][nc] = 0;
                            }
                        }

                    }
                }
            }
        }
        return count;
    }
}