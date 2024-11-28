// Time Complexity :O(m*n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {
    public int numIslands(char[][] grid) {
        Queue<int[]> q= new LinkedList<>();
        int[][] dirs= new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
        int m= grid.length;
        int n= grid[0].length;
        int islands=0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    grid[i][j]='0';
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] cur= q.poll();
                        for(int[] dir: dirs){
                            int r= dir[0]+cur[0];
                            int c= dir[1]+cur[1];

                            if(r>=0 && c>=0 && r<m && c<n && grid[r][c]=='1'){
                                grid[r][c]='0';
                                q.add(new int[]{r,c});
                            }
                        }
                    }
                    islands++;
                }
            }
        }
        return islands;
    }
}
