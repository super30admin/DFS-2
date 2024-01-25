// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

import java.util.LinkedList;
import java.util.Queue;
public class Island {
    public int numIslands(char[][] grid) {

      Queue <int[]> queue = new LinkedList<int[]>();
      int[][] dist = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
      int m= grid.length;
      int n= grid[0].length;
      int count=0;

      for(int i =0; i<m; i++ ){
        for(int j =0; j<n;j++ ){
          if(grid[i][j]=='1'){
            count++;
            queue.add(new int[]{i,j});
            grid[i][j]='0';
          }

          while(!queue.isEmpty()){
            int[] temp = queue.poll();

            for( int[] d: dist){
              int r= temp[0]+d[0];
              int c= temp[1]+d[1];
              if(r>=0 && c>=0 && r<m && c<n && grid[r][c]=='1') {
                queue.add(new int[]{r,c});
                grid[r][c]='0';
              }
            }
          }
        }
      }
      return count;
    }

  }
