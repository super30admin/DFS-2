import java.util.LinkedList;
import java.util.Queue;

//Time complexity- O(m*n)
//Space Complexity- O(min (m,n))
//Successfully ran on leetcode-

class Solution {
 int total;
 int[][] dirs;
 int m,n;
 public int numIslands(char[][] grid) {
     
     if(grid==null || grid.length==0 ) return 0;
     
      m= grid.length;
      n= grid[0].length;
     dirs= new int[][] {{-1,0},{1,0}, {0,1},{0,-1}};
     
     for(int i=0; i<m; i++){
         for(int j=0; j< n; j++){
             
             if(grid[i][j]=='1'){
             total++;
             // dfs(i,j, grid);
             Queue<int[]> q= new LinkedList<>();
                 grid[i][j]= '0';
                 q.add(new int[] {i,j});
                 //start of bfs
                 while(!q.isEmpty()){
                 int[] curr= q.poll();
                 for(int[] dir: dirs){
                     int nr= curr[0]+ dir[0];
                     int nc= curr[1]+ dir[1];
                     
                     if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='1'){
                         q.add(new int[] {nr,nc});
                         grid[nr][nc]='0';
                     }
                     
                  }
              }
           }
        }
     }
     return total;
 }
}
 