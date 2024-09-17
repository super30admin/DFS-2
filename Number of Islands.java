// Time Complexity : O(m*n)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : YEs
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int m;
    int n;
    int [][] dirs;
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int island = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]== '1'){
                    grid[i][j] = '0';
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[]curr = q.poll();
                        for(int[] dir:dirs){
                            int nr = dir[0]+curr[0];
                            int nc = dir[1]+curr[1];
                            if(nr>=0&&nr<m&&nc>=0&&nc<n&&grid[nr][nc]=='1'){
                                grid[nr][nc]='0';
                                q.add(new int[]{nr,nc});
                            }
                        }
                    }
                    island++;
                }
            }
        }
        return island;
    }
    
    private void dfs(char[][]grid,int r,int c){
        if(r<0 || r>=m || c<0 || c>=n || grid[r][c]!='1')
            return;
        grid[r][c]='0';
        for(int[] dir: dirs){
            int nr = dir[0]+r;
            int nc = dir[1]+c;
            dfs(grid,nr,nc);
        }
    }
}
