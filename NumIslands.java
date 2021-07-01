import java.util.Queue;

/**
 * @author Vishal Puri
 * // Time Complexity : O(m*n)
 * // Space Complexity : O(m*n)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class NumIslands {
    int res=0,m,n;
    int [][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return res;
        m=grid.length;
        n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    res++;
                    bfs(grid, i, j);
                }
            }
        }
        return res;
    }
    private void bfs(char [][] grid, int r, int c){
        Queue<int[]> q = (Queue<int[]>) new LinkedList();
        grid[r][c] = '2';
        q.add(new int[]{r,c});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int nr= curr[0]+dir[0];
                int nc= curr[1]+dir[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1'){
                    grid[nr][nc]='2';
                    q.add(new int[]{nr,nc});
                }
            }
        }
    }
}