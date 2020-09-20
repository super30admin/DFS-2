// Time Complexity :O(n*m)
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// traverse and find any cell containing '1'
// start recursion from that searching in all 4 directions as below
// if you find 1 change it to '0' and then continue.
// if the recursion for one cell is ended then it means all of 1's in that island are changed to '0'. Increment counter by 1 (1 island)
// move on to next available cell containing '1' and do the same process again.

class Solution {
    public int numIslands(char[][] grid) {
        int count=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    recur(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};

    private void recur(char[][] grid, int i, int j){
        grid[i][j]='0';
        for(int[] dir:dirs){
            int r=dir[0]+i;
            int c=dir[1]+j;
            if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]=='1'){
                recur(grid,r,c);
            }
        }
    }
}