// Time Complexity : O(MXN)
// Space Complexity : Min(M,N)
// Did this code successfully run on Leetcode : Yes

class Solution {
    int total;
    int dirs[][];
    int m;
    int n;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        total = 0;
        dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        m = grid.length;
        n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    total++;
                    Queue<int[]> q = new LinkedList<>();
                    grid[i][j] = '0';
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        for(int[] dir:dirs){
                            int nr = cur[0] + dir[0];
                            int nc = cur[1] + dir[1];
                            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                q.add(new int[]{nr,nc});
                            }
                        }
                    }
                }
            }
        }
        return total;
    }
}