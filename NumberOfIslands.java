class Solution {
    public int numIslands(char[][] grid) {
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}}; // right,down,left,top
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '0';
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int size = q.size();
                        // level processing -- here processing all the connected components
                        for(int k=0;k<size;k++){
                            int[] temp = q.poll();
                            for(int[] dir:dirs){
                                int nr = temp[0] + dir[0];
                                int nc = temp[1] + dir[1];
                                // bound check
                                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]!='0'){
                                    grid[nr][nc] = '0';
                                    q.add(new int[]{nr,nc});
                                }
                            }
                        }
                        
                    }
                }
            }
        }
        return count;
    }
}