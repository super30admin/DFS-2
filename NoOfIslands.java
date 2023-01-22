// Time Complexity : O(mn)
// Space Complexity : O(min(m,n)) minimum of m and n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//bfs
//in this approach we first find the 1 and add it to the queue and increment the count then we make it 0. Now we process all its connected components and make them
//0 too and add to the queue. We repeat this if we find another island anc return the count int the end.
class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        if(grid == null || grid.length ==0)return 0;
        int m = grid.length;
        int n = grid[0].length;
        int [][] dirs = new int [][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int []> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                   result++;
                   q.add(new int[]{i,j});
                   grid[i][j] = '0';
                   while(!q.isEmpty()){
                        int [] curr = q.poll();
                        for(int []dir : dirs){
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if(nr>=0 && nr<m && nc>=0 && nc<n 
                            && grid[nr][nc] == '1'){
                                q.add(new int[]{nr,nc});
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }
        return result;
        
    }
}

//dfs
// Time Complexity : O(mn)
// Space Complexity : O(mn)
class Solution {
    int [][] dirs;
    public int numIslands(char[][] grid) {
        int result = 0;
        if(grid == null || grid.length ==0)return 0;
        int m = grid.length;
        int n = grid[0].length;
        dirs = new int [][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                   result++;
                   dfs(grid, m,n, i,j);
                }
            }
        }
        return result; 
    }
    private void dfs(char[][] grid, int m, int n, int r, int c){
        //base
        if(r<0 || r==m || c<0 || c==n || grid[r][c] == '0')return;
        grid[r][c] = '0';
        for(int [] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(grid,m,n,nr,nc);
        }
    }
}