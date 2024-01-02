//Time Complexity:O(m*n)
//Space Complexity: min(m,n)
//BFS
class Solution {
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]=='1'){
                    q.add(new int[]{i,j});
                    grid[i][j]='0';
                    numberOfIslands++;
                while(!q.isEmpty()){
                    int[] currentPos = q.poll();
                    for(int[] dir: directions){
                        int row = currentPos[0]+dir[0];
                        int col = currentPos[1]+dir[1];

                        if(row>=0 && col >=0 && row<m && col < n && grid[row][col] == '1'){
                            grid[row][col] = '0';
                            q.add(new int[]{row,col});
                        }
                            
                    }
                }
                }
            }
        }
        return numberOfIslands;
    }
}

//Time Complexity:O(m*n)
//Space Complexity: O(m*n)
//DFS
class Solution {
    int m , n, numberOfIslands;
    int[][] directions ;
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        this.directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        this.m = grid.length;
        this.n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]=='1'){
                    this.numberOfIslands++;
                    dfs(grid,i,j);
                }
            }
        }
        return this.numberOfIslands;
    }

    private void dfs(char[][] grid,int i, int j){
         grid[i][j] = '0';
        for(int[] dir: this.directions){
                        int row = i+dir[0];
                        int col = j+dir[1];

                        if(row>=0 && col >=0 && row<m && col < n && grid[row][col] == '1'){
                            
                            dfs(grid,row,col);
                        }
        }
    }
}//Time Complexity:O(m*n)
//Space Complexity: O(m*n)
//DFS
class Solution {
    int m , n, numberOfIslands;
    int[][] directions ;
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        this.directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        this.m = grid.length;
        this.n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]=='1'){
                    this.numberOfIslands++;
                    dfs(grid,i,j);
                }
            }
        }
        return this.numberOfIslands;
    }

    private void dfs(char[][] grid,int i, int j){
         grid[i][j] = '0';
        for(int[] dir: this.directions){
                        int row = i+dir[0];
                        int col = j+dir[1];

                        if(row>=0 && col >=0 && row<m && col < n && grid[row][col] == '1'){
                            
                            dfs(grid,row,col);
                        }
        }
    }
}
//Time Complexity:O(m*n)
//Space Complexity: min(m,n)
//BFS
class Solution {
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]=='1'){
                    q.add(new int[]{i,j});
                    grid[i][j]='0';
                    numberOfIslands++;
                while(!q.isEmpty()){
                    int[] currentPos = q.poll();
                    for(int[] dir: directions){
                        int row = currentPos[0]+dir[0];
                        int col = currentPos[1]+dir[1];

                        if(row>=0 && col >=0 && row<m && col < n && grid[row][col] == '1'){
                            grid[row][col] = '0';
                            q.add(new int[]{row,col});
                        }
                            
                    }
                }
                }
            }
        }
        return numberOfIslands;
    }
}