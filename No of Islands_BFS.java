// this is BFS Solution. Add one element which is equivalent to 1 in queue and process all it's neighbours with the help of dirs[] , if they are equivalent to 1, convert them to zero. So this loop doesn't stop until a whole island has been changed from 1 to 0. Then the next 1 we find should be compulsorily from next island.
//Time Complexity = O(2*(M*N)) because each element will be processed only twice
//Space Complexity = O(M*N)
class Solution {
    public int numIslands(char[][] grid) {
        //base
        if(grid == null || grid.length ==0) return 0;
        Queue<int[]> q = new LinkedList<>();
        int count=0;
        // System.out.println(grid[0][0]);
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int i =0; i< grid.length; i++){
            for(int j =0; j<grid[0].length;j++){
                if(grid[i][j]== '1'){
                    //island count
                    count += 1;
                    // System.out.println(count);
                    //adding it to queue
                    q.add(new int[]{i,j});
                    grid[i][j]=0;
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir: dirs){
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            //processing nearby elements ,convert to 0
                            //adding them back to queue
                            if(nr >=0 && nc >=0 && nr < grid.length
                                    && nc < grid[0].length && grid[nr][nc]=='1'){
                                grid[nr][nc] = '0';
                                q.add(new int[]{nr,nc});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}