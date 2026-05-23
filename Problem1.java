class Problem1 {
    int[][] dirs;
    int m,n;

    public int numIslands(char[][] grid) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m = grid.length;
        this.n = grid[0].length;
        int count = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '0';

                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir: dirs){
                            int r = dir[0] + curr[0];
                            int c = dir[1] + curr[1];

                            if(r>=0 && c>=0 && r<m && c<n && grid[r][c] == '1'){
                                q.add(new int[]{r,c});
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
