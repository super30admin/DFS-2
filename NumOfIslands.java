// Time Complexity : O(m*n). m is the number of rows and n is the number of columns
// Space Complexity :Minimum between m and n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int numIslands(char[][] grid) {
	        if(grid==null || grid.length==0) return 0;
	        
	        int count=0;
	        Queue<int[]> q = new LinkedList();
	        int dirs[][]=new int[][]{
	            {0,1},
	            {0,-1},
	            {1,0},
	            {-1,0}
	        };
	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid[0].length;j++){
	                
	                if(grid[i][j]=='1') {
	                q.add(new int[]{i,j});
	            while(!q.isEmpty()){
	            int curr[] = q.poll();
	            for(int f=0;f<dirs.length;f++){
	                int[] dir = dirs[f];
	                int r=dir[0]+curr[0];
	                int c =dir[1]+curr[1];
	                
	                if(r>=0 && r<grid.length&&c>=0&&c<grid[0].length&&grid[r][c]=='1'){
	                    grid[r][c]='0';
	                    q.add(new int[]{r,c});
	                }
	            }
	         }
	            count++;
	            }
	        
	    }
	}
	        
	     return count;   
	    }
}
