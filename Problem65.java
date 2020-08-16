Time Complexity : O(M*N) where M is the number of rows && N is the number of columns
Space Complexity : Minimum(O(M),O(N))


//DFS

class Solution {
    
    int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length<1) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        for(int[] dir : directions){
            int r = i+dir[0];
            int c = j+dir[1];
            if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c] == '1'){
                dfs(grid, r, c);
            }
        }
    }
}

//BFS

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length<1) return 0;
        
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        int[][] directions = {{1,0}, {0,1},{0,-1}, {-1,0}};
        
        for(int i = 0; i<grid.length; i++){
            for(int j = 0 ; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    q.offer(new int[]{i,j});
                    grid[i][j] = '0';
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        for(int[] dir : directions){
                            int r = cur[0] + dir[0];
                            int c = cur[1] + dir[1];
                            if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]=='1'){
                                q.offer(new int[]{r,c});
                                grid[r][c] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}