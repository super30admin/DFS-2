// Time Complexity : O(mxn) 
// Space Complexity : O(mxn) -dfs, O(min(m,n)) -bfs
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Find the mid of the list and then reverse the second half and do the comparision.

class Solution {
    public int numIslands2(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int [][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<r; i++){
            for(int j=0;j<c; j++){
                if(grid[i][j] == '1'){
                    result++;
                    q.add(new int[]{i,j});
                    grid[i][j] = '0';
                    // run the bfs
                    while(!q.isEmpty()){
                        int [] cur = q.poll();
                        for(int [] dir: dirs){
                            int nr = cur[0] + dir[0];
                            int nc = cur[1] + dir[1];
                            //bound checks
                            if(nr >= 0 && nc >= 0 && nr < r && nc < c && grid[nr][nc] == '1'){
                                q.add(new int []{nr,nc});
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int [][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int result = 0;
        // Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<r; i++){
            for(int j=0;j<c; j++){
                if(grid[i][j] == '1'){
                    result++;
                    // run the dfs
                    dfs(grid,i,j,r,c,dirs);
                   
                }
            }
        }
        return result;
    }

    private void dfs(char [][] grid, int i, int j, int m, int n, int [][] dirs){
        //base
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0') return;
        //logic
        grid[i][j] = '0';
        for(int [] dir: dirs){
            int nr = i + dir[0];
            int nc = j+ dir[1];
            dfs(grid,nr,nc,m,n,dirs);
        }
    }
}