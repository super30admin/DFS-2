//BFS

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
       int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0, -1}};
        int count=0;
          Queue<int []> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    q.add(new int[]{i,j});
                    grid[i][j]='0';
                    while(!q.isEmpty()){
                        
                        int[] curr = q.poll();
                         for(int[] dir: dirs){
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            if(r>=0 && r<m && c>=0 && c<n && grid[r][c]=='1'){
                                q.add(new int[] {r,c}); 
                                grid[r][c]='0';
                            } 
                        }
                    }
                }
            }
        }
        return count;
    }  
}

/Time complexity: O(m* n)
//Space complexity: O(min(m,n)) 

//DFS

class Solution {
    
    int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0, -1}};
    int count;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        count=0;
        for(int i=0;i<m;i++){
            for(int j = 0;j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, m,n);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j, int m, int n){
        if(i<0 || i==m || j<0 || j==n || grid[i][j] == '0') return;
        grid[i][j]='0';
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
                 dfs(grid, r,c,m,n);  
                }
    }
}
/Time complexity: O(m* n)
//Space complexity: O(m* n)
