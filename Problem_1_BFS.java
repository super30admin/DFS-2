/* 
 * Time Complexity : O(m*n)
 * Space Complexity : O(min of m and n)
 * 
 */

import java.util.LinkedList;
import java.util.Queue;

public class Problem_1_BFS {

	 public int numIslands(char[][] grid) {
	        
	        if(grid == null || grid.length == 0){
	            return 0;
	        }
	        
	        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	        int count = 0;
	        for(int i=0; i<grid.length; i++){
	            for(int j=0; j<grid[0].length; j++){
	                if(grid[i][j] == '1'){
	                    Queue<int[]> queue = new LinkedList<>();
	                    count++;
	                    grid[i][j] = '0';
	                    queue.add(new int[]{i, j});
	                    
	                    while(!queue.isEmpty()){
	                        int[] pos = queue.poll();
	                    
	                        for(int[] dir : dirs){
	                            int r = dir[0] + pos[0];
	                            int c = dir[1] + pos[1];

	                            if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length
	                               && grid[r][c] == '1'){
	                                grid[r][c] = '0';
	                                queue.add(new int[]{r, c});
	                            }
	                        }    
	                    }
	                    
	                }
	            }
	        }
	        
	        return count;
	        
	    }
	   
}
