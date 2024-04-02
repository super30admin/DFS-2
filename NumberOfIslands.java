import java.util.LinkedList;
import java.util.Queue;
// tc = o(m*n)
// sc = o(min(m,n))
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<int[]> q = new LinkedList<>();

        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}}; // write correct directions array
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '0';
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] current = q.remove();
                        for(int[] dir:dirs){
                            int nr = current[0] + dir[0];
                            int nc = current[1] + dir[1];

                            if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1'){ //should be grid[nr][nc] not grid[i][j]
                                grid[nr][nc] = '0';
                                q.add(new int[]{nr,nc});
                            }
                        }


                    }
                    
                }
            }
        }
        return count;
    }
}