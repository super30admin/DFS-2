import java.util.LinkedList;
import java.util.Queue;

//Time Complexity: O(m*n)
// Space Complexity: O(m*n)
// Approach: BFS

public class NumIslands {
    class Solution {
        public int numIslands(char[][] grid) {
            if(grid == null || grid.length ==0){
                return 0;
            }
            int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};

            int m = grid.length;
            int n = grid[0].length;
            int count =0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j] == '1'){
                        count++;
                        Queue<int[]> q = new LinkedList<>();
                        grid[i][j] ='2';
                        q.add(new int[]{i,j});
                        while(!q.isEmpty()){
                            int[] val = q.poll();
                            for(int[] dir : dirs){
                                int nr = val[0]+dir[0];
                                int nc = val[1]+dir[1];
                                if(nr >=0 && nr < m && nc >=0 && nc <n && grid[nr][nc] == '1'){
                                    q.add(new int[]{nr,nc});
                                    grid[nr][nc] ='2';
                                }
                            }
                        }
                    }
                }
            }
            return count;
        }
    }
}
