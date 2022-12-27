// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach

import java.util.*;

public class NumberOfIslands {

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            Queue<int[]> q = new LinkedList<>();
            int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
            int m= grid.length;
            int n=grid[0].length;
            int cnt =0;
            for (int i= 0;i<m;i++){
                for (int j= 0;j<n;j++){
                    if (grid[i][j]== '1'){
                        q.add(new int[]{i,j});
                        grid[i][j]='0';
                        cnt++;
                    }
                    while (!q.isEmpty()){
                        int[] curr = q.poll();
                        for (int[] dir : dirs){
                            int nr = dir[0]+curr[0];
                            int nc = dir[1]+ curr[1];
                            if (nr >=0 && nr <m  && nc >=0 && nc < n && grid[nr][nc]=='1'){
                                q.add(new int[]{nr,nc});
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
            return cnt;
        }

        
    
}
