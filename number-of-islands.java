number-of-islands
Time:O(m*n)
Space:O(m*n)



class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    count++;
                    q.add(new int[]{i,j});
                    
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        
                        for(int[] dir:dirs){
                            int r = curr[0]+dir[0];
                            int c = curr[1]+dir[1];
                            if(r>=0 && r<m && c>=0 && c <n && grid[r][c]=='1'){
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