class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null) return 0;
        Queue<int []>q= new LinkedList<>();
        
        int count = 0;
        int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                     count ++;
                    q.add(new int [] {i,j});
                    grid[i][j]='2';
                    while(!q.isEmpty()){
                        int [] cur =q.poll();
                        for(int [] dir : dirs){
                            int row = cur[0] + dir[0];
                            int col = cur[1]+ dir[1];
                            if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && grid[row][col] == '1'){
                                q.add(new int []{row,col});
                                grid[row][col] = '2';
                            }
                        }
                    }
                   
                }
            }
        }
        return count;
    }
}