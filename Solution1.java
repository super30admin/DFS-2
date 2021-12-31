// Time Complexity :O(m*n) size of grid array
// Space Complexity : O(m*n) maximum element in the queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class Solution {
    //BFS
    public int numIslands(char[][] grid) {
        int [][] dirs=new int [][]{{0,1},{-1,0},{1,0},{0,-1}};
        int m=grid.length;
        int n=grid[0].length;
        int total=0;
        Queue<int []> q= new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    grid[i][j]='0';
                    q.add(new int [] {i,j});
                    while(!q.isEmpty()){
                        int[] curr= q.poll();
                        for(int[] dir:dirs){
                            int nr=curr[0]+dir[0];
                            int nc=curr[1]+dir[1];
                            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='1'){
                                grid[nr][nc]='0';
                                q.add(new int[]{nr,nc});
                            }
                        }
                    }
                    total++;
                    }
                
                
            }
        }
        
        return total;
    }

//DFS
// Time Complexity :O(m*n) size of grid array
// Space Complexity : O(m*n) maximum element in the recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
       int total;
       int m;
       int n;
       int [][]dirs;
       public int numIslands1(char[][] grid) {
         dirs=new int [][]{{0,1},{-1,0},{1,0},{0,-1}};
           m=grid.length;
           n=grid[0].length;
           total=0;
           for(int i=0;i<m;i++){
               for(int j=0;j<n;j++){
                   if(grid[i][j]=='1'){
                       total++;
                       dfs(grid,i,j);
                   }
               }
           }
           
           return total;
       }
       
       private void dfs(char[][]grid,int i,int j){
           
           //base
           if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0')
               return;
           //logic
           grid[i][j]='0';
           for(int[] dir:dirs){
               int nr=dir[0]+i;
               int nc=dir[1]+j;
               dfs(grid,nr,nc);
           }
       }
}