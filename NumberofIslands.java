// TC: O(M X N)
// SC: O(M X N)

// USING BFS

class Solution {
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0 ; i< m; i++){
            for(int j = 0 ;j<n ;j++){
                if(grid[i][j] == '1'){
                count++;
                q.add(new int[]{i,j});
                while(!q.isEmpty()){
                    int[] curr = q.poll();
                    
                    for(int[] dir:dirs){
                        int r = curr[0] + dir[0];
                        int c = curr[1] + dir[1];
                        
                        if( r>=0 && r < m && c>=0 && c < n && grid[r][c] == '1'){
                            grid[r][c] = '2';
                                q.add(new int[]{r,c});
                        }
                    }
                }
            }
            }
        }
        return count;
    }
}

// USING DFS
class Solution {
    int m, n;
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0){
            return 0;
        }
         m = grid.length;
         n = grid[0].length;
        int count = 0 ;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    
    private void dfs(char[][] grid, int row, int col){
        //base
        if(row < 0 || col < 0 || row >= m || col >=n || grid[row][col] != '1'){
            return;
        }
        
        //logic
        grid[row][col] = '2';
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir : dirs){
            int r = row + dir[0];
            int c = col + dir[1];
            dfs(grid, r,c);
        }
    }
}