//DFS
//TC: O(m*n)
//SC: O(m*n)
class Solution {
    int m; int n;
    public int numIslands(char[][] grid) {
        m = grid.length; n = grid[0].length;
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }
    
    private void dfs(char [][] grid, int i, int j){
        //base
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
        //logic
        grid[i][j] = '0';
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            
            if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1'){
                dfs(grid, r, c);
            }
        }
    }
}


//BFS
//TC: O(m*n)
//SC: O(min(m, n))
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length; int n = grid[0].length; int result = 0;
        Queue<int[]> q = new LinkedList(); int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
         for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    q.add(new int[]{i,j});
                    result++;
                    
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir : dirs){
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            
                            if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1'){
                                grid[r][c] = '0';
                                q.add(new int[]{r,c});
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
