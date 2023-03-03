/*
Number of islands
approach: we'll do a dfs for every 1 encountered and mark it's neighbors as visited.
time: O(mxn)
space: O(mxn)
 */
public class Problem1 {

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {

                if(grid[i][j]=='1' && !visited[i][j]) {
                    count++;
                    helper(grid, visited, m, n, i, j);
                }
            }
        }
        return count;
    }

    private void helper(char[][] grid, boolean[][] visited, int m, int n, int r, int c) {

        if(r==m || r<0 || c==n || c<0 || visited[r][c] || grid[r][c]!='1') return;

        visited[r][c] = true;
        for(int[] dir: dirs) {

            int nr = dir[0]+r;
            int nc = dir[1]+c;

            helper(grid, visited, m, n, nr, nc);
        }
    }
}
