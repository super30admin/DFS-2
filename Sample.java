// Time Complexity : O[M*N]
// Space Complexity :O[1]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding the logic


// Your code here along with comments explaining your approach
class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j]=='1'){
                    //Incrementing the value of count for every position where land is found
                    count++;
                    mark(grid,i,j);
                }
            }
        }
        return count;
    }
    
    //Marking the neighbours of the land as been already visited
    public static void mark (char [][] grid, int x, int y){
        if (x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]=='0') return;
        grid[x][y]='0';
        mark(grid,x+1,y);
        mark(grid,x-1,y);
        mark(grid,x,y+1);
        mark(grid,x,y-1);
    }
}