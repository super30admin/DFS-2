public class NoOfIslands {
    //DFS
    private int m;
    private int n;
    public int numIslands(char[][] grid) {
        //edge case
        m = grid.length;
        if(grid == null || m == 0) return 0;
        n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs (char[][] grid, int i, int j){

        // base case

        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;

        int[][] dirs = new int [][] {{0,1},{1,0}, {-1,0},{0,-1}};

        grid[i][j] = '0';

        for(int[] dir: dirs){

            int r = i+dir[0];

            int c = j+dir[1];

            dfs(grid,r,c);

        }

    }


}
//BFS
/*
 public int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0) return 0;

        int count =0;

        int m = grid.length;

        int n = grid[0].length;

        int [][] dirs = new int [][] {{0,1}, {1,0}, {-1,0}, {0,-1}};

        for(int i = 0; i <  m; i++){

            for(int j = 0; j < n; j++){

                if(grid[i][j] == '1'){

                    count++;

                    Queue <int []> q = new LinkedList<>();

                    q.add(new int[] {i,j});

                    grid[i][j] = '0';

                    while(!q.isEmpty()){

                        int [] curr = q.poll();

                        for(int [] dir : dirs){

                            int r = curr[0] + dir[0];

                            int c = curr[1] + dir[1];

                            if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1'){

                                 q.add(new int[] {r,c});

                                 grid[r][c] = '0';

                            }

                        }

                    }

                }

            }

        }

        return count;

    }
* */