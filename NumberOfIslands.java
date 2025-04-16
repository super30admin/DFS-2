class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int [][] directions =new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}}; 
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++)
            {
                Queue<int[]> myQueue = new LinkedList();
                if(grid[i][j] == '1')
                {
                    count++;
                    myQueue.add(new int[]{i,j});
                    grid[i][j] = '0';
                }
                while(!myQueue.isEmpty()){
                    int[] curr = myQueue.poll();
                    for(int [] dir: directions){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r >=0 && c>=0 && r<m && c<n && grid[r][c]=='1'){
                        myQueue.add(new int[]{r,c});
                        grid[r][c] ='0';
                        }
                    }
                }
            }
        }
    return count;
    }   
}