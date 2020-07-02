Execute in Leet code-Yes
Time complexity-o(m*n)
space complexity-o(m*n)

class Solution {
    public int numIslands(char[][] grid) {
        Queue<int[]> q= new LinkedList<>();
        int count=0;
        if(grid==null || grid.length==0) return count;
        int m=grid.length;
        int n=grid[0].length;
        int[][] dirs = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
        for(int i=0;i< m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] cur= q.poll();
                        for(int[] dir:dirs){
                            int r=cur[0]+dir[0];
                            int c=cur[1]+dir[1];
                            if(r>=0&& r<m && c>=0 && c<n && grid[r][c]=='1'){
                                q.add(new int[]{r,c});
                                grid[r][c]='0';
                            }
                        }
                    }
                    
                }
            }
        }
        return count;
        
    }
}
