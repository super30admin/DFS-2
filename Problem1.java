// Approach - I
// BFS

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n  = grid[0].length;
        int count = 0;
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (grid[i][j]=='1'){
                    Queue<int []> q = new LinkedList<>();
                    count++;
                    q.add(new int []{i, j});
                    grid[i][j] = '0';

                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int []k: dir){
                            int nr = k[0] + curr[0];
                            int nc = k[1] + curr[1];
                            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                q.add(new int []{nr, nc});
                            }
                        }

                    }
                }
               
            }
        }
        return count;
    }
}


//Approach - II 
// DFS

class Solution {
    int m;
    int n;
    int[][]dir;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        dir = new int [][]{{1,0},{0,1},{-1,0},{0,-1}};
        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] matrix, int i, int j){
        //Base Case
        if(i < 0 || j <0 || i == m || j == n ||  matrix[i][j] == '0') return ;
        //Logic
        matrix[i][j] = '0';
        for(int [] d: dir){
            int nr = d[0] + i;
            int nc = d[1] + j;
            dfs(matrix, nr, nc);

        }
    }
}