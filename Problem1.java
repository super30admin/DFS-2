public class Problem1 {
    //t.c->O(m*n)
    //sc->O(m+n) -> not everytime we have everyelement in queue
    class BFS {
        public int numIslands(char[][] grid) {
            if(grid == null || grid.length == 0){
                return 0;
            }
            int rowLength = grid.length;
            int colLength = grid[0].length;
            int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
            int count = 0;
            for(int i = 0;i<rowLength;i++){
                for(int j = 0;j<colLength;j++){
                    //do bfs everytime we find a one so nothing can be missed
                    if(grid[i][j]=='1'){
                        count++;
                        grid[i][j]='2';
                        Queue<int[]> q = new LinkedList<>();
                        q.add(new int[]{i,j});
                        while(!q.isEmpty()){
                            int[] curr = q.poll();
                            for(int[] dir : dirs){
                                int nr = dir[0]+ curr[0];
                                int nc = dir[1] + curr[1];
                                if(nr>=0 && nr<rowLength && nc >=0 && nc<colLength && grid[nr][nc] =='1'){
                                    q.add(new int[]{nr,nc});
                                    grid[nr][nc] ='2';
                                }
                            }
                        }
                    }
                }
            }
            return count;
        }
    }



    //tc ->O(m*n)
    //sc->O(m*n)
    class dfs {
        int rowLength ;
        int colLength;
        int[][] dirs;
        public int numIslands(char[][] grid) {
            if(grid == null || grid.length == 0){
                return 0;
            }
            rowLength = grid.length;
            colLength = grid[0].length;
            dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
            int count = 0;
            for(int i = 0;i<rowLength;i++){
                for(int j = 0;j<colLength;j++){
                    //do dfs everytime we find a one so nothing can be missed
                    if(grid[i][j]=='1'){
                        count++;
                        dfs(grid,i,j);
                    }
                }
            }
            return count;
        }
        private void dfs(char[][] grid, int row, int col){
            //base
            if(row<0 ||row ==rowLength || col<0 || col == colLength || grid[row][col]!='1'){
                return;
            }
            //logic
            grid[row][col] = '2';
            for(int[] dir: dirs){
                int nr = row+ dir[0];
                int nc = col + dir[1];
                dfs(grid,nr,nc);
            }

        }
    }
}
