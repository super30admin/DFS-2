


import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class numberOfIsland {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)
            return 0;
        
        int [][] dirs = new int [][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int count=0;
        Queue<int []> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    q.add(new int[]{i,j});
                    grid[i][j]='0';
                    while(!q.isEmpty()){
                        int[] curr=q.poll();
                        for(int[] dir:dirs){
                            int r=dir[0]+curr[0];
                            int c=dir[1]+curr[1];
                            if(r>=0 && r<m && c>=0 && c<n && grid[r][c]=='1'){
                                grid[r][c]='0';
                                q.add(new int[]{r,c});
                            }
                        }
                    }
                    
                }
            }
        }
        return count;
    }
    
}
