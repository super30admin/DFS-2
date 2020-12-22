// Time Complexity :O(N*M) 
// Space Complexity :O(N*M) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach: Traverse throught the matrix and if found 1 change it to 0 and do depth
// first search and increase the count once finished.
class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if( grid[i][j]=='1'){
                    move(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void move(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!='1' ){
            
            return ;
        }
        grid[i][j]='0';
        move(grid,i+1,j);
        move(grid,i-1,j);
        move(grid,i,j+1);
        move(grid,i,j-1);
    }
}