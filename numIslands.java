// Time Complexity :O(MxN)
// Space Complexity :O(MxN)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int numIslands(char[][] grid) {
        int islands=0;
        for(int i=0;i<grid.length;i++){
            for(int j =0;j <grid[0].length;j++){
                islands += helper(i,j,grid);
            }
        }
        return islands;
    }
    private  int helper(int i,int j,char [][] grid){
        if(i<0 || i>= grid.length || j<0 || j >= grid[0].length || 
           grid[i][j] =='0' ||  grid[i][j] =='$' ){
            return 0;
        }
        grid[i][j] ='$';
        
        helper(i,j+1,grid);
        helper(i,j-1,grid);
        helper(i+1,j,grid);
        helper(i-1,j,grid);
        return 1;
    }
}
