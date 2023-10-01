



class Solution {
    int [][] dirs;
    
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count =0;
        dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]>q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    
                    grid[i][j] = '0';
                    q.add(new int[]{i,j});

                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir:dirs){
                            int nr = dir[0] + curr[0];
                            int nc = dir[1] + curr[1];
                            if(nr<m && nr>=0 && nc < n && nc >=0 && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                q.add(new int[]{nr,nc});
                            }
                        }
                    }
                    count++;
                }
                
            }
        }
        return count;
    }
}


/**
TC : O(2m*n) --> O(m*n) each number is visited twice.

SC : O min(m,n) --> only minimum of m,n will go inside queue.




Description : Using directions array, visiting all the directions and making 1's to 0.


TC in BFS : 2m * n 
Only In worst case its m*n → all 1’s.
If m*n happens at every number then its (m*n)^2
In Actual TC : m*n → for traversing whole matrix and m*n for doing DFS or BFS, so its 2m*n
Its 2m*n because every number is touching twice. 
Why not m^2 * n^2 → only if m*n at every number then its m^2 * n^2.



 */







class Solution {
    int[][] dirs;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j,m,n);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j, int m, int n){
        //base
        if(i<0 || j<0|| i==m || j==n|| grid[i][j] == '0') return;

        //logic

        grid[i][j] = '0';
        for(int[] dir : dirs){
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            dfs(grid, nr,nc,m,n);
        }
    }
}



/**
TC : O(2m*n) --> O(m*n) each number is visited twice.

SC : O(m*n) --> In worst case all the numnbers will go inside stack.


Description : Using directions array, visiting all the directions and making 1's to 0.






 */