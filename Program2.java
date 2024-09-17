package LeetCode;
/*
 * 
 * 
 * TC = O(m.n)
 *  SC = O(m.n) 
 * 
 * */
public class Program2 {
	class Solution {
	    public int numIslands(char[][] grid) {
	        int count = 0;
	        
	        for(int i=0; i<grid.length; i++){
	            for(int j=0; j<grid[0].length; j++){
	                if(grid[i][j] == '1')
	                 count += helper(i,j,grid);
	            }
	        }
	        return count;
	    }
	    
	    public int helper(int i, int j, char[][]count){
	        if(i<0 || i>=count.length || j<0 || j>=count[0].length || count[i][j] == '0')
	            return '0';
	        
	        count[i][j] = '0';
	        helper(i+1,j,count);
	        helper(i-1,j,count);
	        helper(i,j+1,count);
	        helper(i,j-1,count);
	        
	        return 1;
	    }
	}

}
