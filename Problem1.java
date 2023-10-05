
//TimeComplexity  : O(m*n)
//Space Complexity : O(m+n)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No
import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count=0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '2';
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir : dirs){
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] +dir[1];
                            if(nr >=0 && nr< m && nc>=0 && nc < n && grid[nr][nc] == '1'){

                                grid[nr][nc] = '2';
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
