// dfs soln
// Time Complexity : O(M * N)
// Space Complexity : O(M * N)
// Did this code successfully run on Leetcode : Yes

class Solution {
    int m; int n;
    int count = 0;
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        m = grid.length; n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j< n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i , j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int row, int col){
        //base
        if(row < 0 || row == m || col < 0 || col == n || grid[row][col] != '1')
            return;
        //logic
        grid[row][col] = '0';
        for(int[] dir: dirs){
            int r = dir[0] + row;
            int c = dir[1] + col;
            dfs(grid, r, c);
        }
    }
}


/*
// bfs soln
// Time Complexity : O(M * N)
// Space Complexity : O(min(M, N))
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        Queue<Integer> q = new LinkedList<>(); 
        int m = grid.length; int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j< n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    q.add(i);
                    q.add(j);
                    grid[i][j] = '0';
                    while(!q.isEmpty()){
                        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
                        int rc = q.poll(); int cc = q.poll();
                        for(int[] dir: dirs){
                            int r = dir[0] + rc;
                            int c = dir[1] + cc;
                            if(r >=0 && r < m && c>=0 && c < n && grid[r][c] == '1'){
                                grid[r][c] = '0';
                                q.add(r);
                                q.add(c);
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
*/